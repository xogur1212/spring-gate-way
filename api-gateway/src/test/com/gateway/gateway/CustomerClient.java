package com.gateway.gateway;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Project : spring-cloud-gateway
 * Created by OKESTRO
 * Developer : th.eom
 * Date Time : 2022/09/13 1:34 PM
 * Summary :
 **/
@Slf4j
public class CustomerClient {

    public static void main(String[] args) {
        String s = "foo";
        String b = "bar";

        log.info("Answer ={}", isIsomorphic(s, b));

        String c = "badc";
        String f = "baba";

        log.info("Answer2 = {} ", isIsomorphic(c, f));
    }

    public static boolean isIsomorphic(String s, String t) {

        String[] sSplit = s.split("");

        String[] tSplit = t.split("");

        int size = sSplit.length;
        Map<String, String> isIsomorphicMap = new HashMap<>();
        Map<String, String> reverseMap = new HashMap<>();

        for (int count = 0; count <= size - 1; count++) {
            isIsomorphicMap.put(sSplit[count], tSplit[count]);
            reverseMap.put(tSplit[count], sSplit[count]);


        }
        for (int count = 0; count <= size - 1; count++) {

            if (isIsomorphicMap.containsKey(sSplit[count])) {

                if (!isIsomorphicMap.get(sSplit[count]).equals(tSplit[count])) {

                    return false;
                }
            }
            if (reverseMap.containsKey(sSplit[count])) {

                if (!reverseMap.get(sSplit[count]).equals(tSplit[count])) {

                    return false;
                }
            }

        }


        return true;

    }
}
