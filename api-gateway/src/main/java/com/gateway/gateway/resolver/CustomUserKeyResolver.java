package com.gateway.gateway.resolver;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Project : spring-cloud-gateway
 * Created by OKESTRO
 * Developer : th.eom
 * Date Time : 2022/09/16 11:16 AM
 * Summary :
 **/
@Configuration
public class CustomUserKeyResolver {
    @Bean
    KeyResolver userKeyResolver() {

        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("userId")));
    }
}