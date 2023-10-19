package com.flow.collegeflowproject.external;

import com.flow.collegeflowproject.db.Classroom;
import com.flow.collegeflowproject.exception.GenericExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemplateRequests {

    @Autowired
    RestTemplate restTemplate;

    @Value("${endpoint.vacancies}")
    private String endpoint;

    public String sendClassroomToStudentService(Classroom classroom){
        restTemplate = new RestTemplate(getClientHttpRequestFactory());

        ResponseEntity<Classroom> response = restTemplate.postForEntity(endpoint,"/classroom" + classroom, Classroom.class);
        if(!response.getStatusCode().equals(HttpStatus.OK)){
            return "Classroom created but Student Service unavailable";
        }else{
            return "Classroom created and available in StudentService";
        }


    }


    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;


    }

}
