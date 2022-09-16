package com.gateway.gateway.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gateway.gateway.model.TokenUser;
import com.gateway.gateway.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Project : spring-cloud-gateway
 * Created by OKESTRO
 * Developer : th.eom
 * Date Time : 2022/09/15 5:00 PM
 * Summary :
 **/
@Component
@RequiredArgsConstructor
public class JwtUtils implements InitializingBean {

    private static final String ROLE_CLAIM_KEY = "role";

    private final JwtProperties jwtProperties;

    private Algorithm algorithm;

    private JWTVerifier jwtVerifier;

    @Override
    public void afterPropertiesSet() {
        this.algorithm = Algorithm.HMAC512(jwtProperties.getSecret());
        this.jwtVerifier= JWT.require(algorithm).acceptLeeway(5).build();       //leeway 시간 여유 시간 몇초 빠르게나 늦게 들어돠도됨
    }

    public boolean isValid(String token){
        try {
            jwtVerifier.verify(token);
            return true;
        } catch (RuntimeException e){
            return false;
        }

    }

    public TokenUser decode(String token) {
        jwtVerifier.verify(token);

        DecodedJWT jwt = JWT.decode(token);

        String id = jwt.getSubject();
        String role = jwt.getClaim(ROLE_CLAIM_KEY).asString();

        return new TokenUser(id, role);
    }

    public String generate(TokenUser user) {
        Date now = new Date();
        Date expiresAt = new Date(now.getTime() + jwtProperties.getExpirationSecond() * 1000);

        return JWT.create()
                .withSubject(user.getId())
                .withClaim(ROLE_CLAIM_KEY, user.getRole())
                .withExpiresAt(expiresAt)
                .withIssuedAt(now)
                .sign(algorithm);
    }

}
