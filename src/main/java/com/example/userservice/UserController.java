package com.example.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user-service")
public class UserController {

    @Value("${ADMIN_SERVICE_ENDPOINT}")
    private String adminServiceEndpoint ;

    @Value("${DATABASE_ENDPOINT}")
    private String databaseEndpoint ;

    @Value("${KAFKA_ENDPOINT}")
    private String kafkaEndpoint ;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello from User Service";
    }

    @GetMapping("/users")
    public String getUsers(){
        return "I have 10 users ";
    }

    @GetMapping("/envs")
    public String getEnvVars(){
        Map<String, String> myMap = new HashMap<>();
        myMap.put("ADMIN_SERVICE_ENDPOINT",adminServiceEndpoint.toString());
        myMap.put("DATABASE_ENDPOINT",databaseEndpoint.toString());
        myMap.put("KAFKA_ENDPOINT",kafkaEndpoint.toString());
        return myMap.toString() ;
    }

    @GetMapping("/connect")
    public String getConnect(){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://"+ adminServiceEndpoint + "/api/admin-service/hello";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<?> result =
                restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return (String)  "Response from admin-service : "+result.getBody().toString() ;
    }


}
