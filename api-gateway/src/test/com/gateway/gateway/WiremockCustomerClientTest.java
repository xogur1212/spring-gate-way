package com.gateway.gateway;


import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


/**
 * Project : spring-cloud-gateway
 * Created by OKESTRO
 * Developer : th.eom
 * Date Time : 2022/09/13 1:02 PM
 * Summary :
 **/

@Import(ApiGatewayApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
@Slf4j
public class WiremockCustomerClientTest {


    @Autowired
    private Environment environment;

    @BeforeEach
    public void setupWireMock() {
        var wiremockServerPort = this.environment.getProperty("wiremock.server.port", Integer.class);
        log.info("wiremockServerPort = {}", wiremockServerPort);

        var base = String.format("%s%s", "localhost", wiremockServerPort);
        var json = """
                [
                    {"id":"1"}
                ]
                    """;

        WireMock.stubFor(
                WireMock.get("/customers")
                        .willReturn(WireMock.aResponse()
                        .withHeader(CONTENT_TYPE,APPLICATION_JSON_UTF8_VALUE)
                        .withBody(json)));

    }

    @Test
    public void getAllCustomers(){
//        var customers = this.client.getAllCustomers();
    }
}
