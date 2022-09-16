package com.gateway.gateway;

import com.gateway.gateway.filter.factory.JwtAuthenticationGatewayFilterFactory;
import com.gateway.gateway.model.TokenUser;
import com.gateway.gateway.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Project : spring-cloud-gateway
 * Created by OKESTRO
 * Developer : th.eom
 * Date Time : 2022/09/15 5:45 PM
 * Summary :
 **/
@SpringBootTest
@Slf4j
public class makeJWT {

    @Autowired
    JwtUtils jwtUtils;
    @Test
    public void 생성(){
        TokenUser tokenUser=new TokenUser();
        tokenUser.setId("id1");
        tokenUser.setRole("ROLE_PARTNER");
        log.info("token ={}", jwtUtils.generate(tokenUser));


    }
}
