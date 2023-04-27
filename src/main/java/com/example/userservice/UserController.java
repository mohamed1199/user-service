package com.example.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user-service")
public class UserController {

    @Value("${DATABASE_ENDPOINT}")
    private String databaseEndpoint ;

    @Value("${KAFKA_ENDPOINT}")
    private String kafkaEndpoint ;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello from User Service ";
    }

    @GetMapping("/users")
    public String getUsers(){
        return "I have 10 users ";
    }

    @GetMapping("/envs")
    public String getEnvVars(){
        Map<String, String> myMap = new HashMap<>();
        myMap.put("DATABASE_ENDPOINT",databaseEndpoint.toString());
        myMap.put("KAFKA_ENDPOINT",kafkaEndpoint.toString());
        return myMap.toString() ;
    }


}
