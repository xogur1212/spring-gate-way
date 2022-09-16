package com.gateway.gateway.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project : spring-cloud-gateway
 * Created by OKESTRO
 * Developer : th.eom
 * Date Time : 2022/09/15 4:28 PM
 * Summary :
 **/
@Component
@ConfigurationProperties("jwt")
@Setter
@Getter
public class JwtProperties {

    private String secret;

    private long expirationSecond;

}




