package com.gateway.gateway.model;

import lombok.*;

/**
 * Project : spring-cloud-gateway
 * Created by OKESTRO
 * Developer : th.eom
 * Date Time : 2022/09/15 4:59 PM
 * Summary :
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TokenUser {

    private String id;
    private String role;

}
