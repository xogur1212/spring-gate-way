package com.gateway.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;

import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/**
 * Project : spring-cloud-gateway
 * Created by OKESTRO
 * Developer : th.eom
 * Date Time : 2022/09/14 10:48 AM
 * Summary :
 **/
@Slf4j
public class AtomicReferenceTest {

    public static void main(String[] args) {

        log.info("{}",generateQueryMap("abc.abc"));

    }
    public static Object generateQueryMap( String key) {
        AtomicReference<String> summedKey = new AtomicReference<>(key);

        Pattern COMPILE =Pattern.compile(".*\\.");

        log.info("answer ={}",COMPILE.matcher(key).matches());
        log.info("answer2 ={}",key.matches(".*\\."));
        if(!COMPILE.matcher(key).matches()){
            return key;
        }else {
            return key.lastIndexOf('.');
        }

//        summedKey.getAndAccumulate("", (p, u) -> {
//
//            p = !COMPILE.matcher(p).matches() ? p : p.substring(0, p.lastIndexOf('.'));
//
//            return p + u;});

       // return summedKey;


    }




}
