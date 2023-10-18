package com.flow.collegeflowproject.external;

import com.flow.collegeflowproject.exception.GenericExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestTemplateRequests {

    @Autowired
    RestTemplate restTemplate;

    @Value("${endpoint.vacancies}")
    private String endpoint;


    public ResponseEntity<Long> findVacancies(Long idClassroom){
        ResponseEntity<Long> response
                = restTemplate.getForEntity(endpoint + "/" + idClassroom, Long.class);

        if(!response.getStatusCode().equals(HttpStatus.OK)){
            throw new GenericExeption("Service unavailable");
        }

        return response;
    }
    public void test(){
        HttpEntity<List<Integer>> request = new HttpEntity<>(List.of(1, 2));
        Integer test = restTemplate.postForObject(endpoint, request, Integer.class);
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;


    }
}
