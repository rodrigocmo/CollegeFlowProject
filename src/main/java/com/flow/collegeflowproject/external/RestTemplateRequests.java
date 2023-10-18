package com.flow.collegeflowproject.external;

import com.flow.collegeflowproject.db.Classroom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


import java.util.List;


@Configuration
public class RestTemplateRequests {


    RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

    @Value("${endpoint.cep}")
    private String endpoint;

    ResponseEntity<Classroom> response
            = restTemplate.getForEntity(endpoint + "/1", Classroom.class);


    HttpEntity<List<Integer>> request = new HttpEntity<>(List.of(1, 2));
    Integer test = restTemplate.postForObject(endpoint, request, Integer.class);

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;


    }
}
