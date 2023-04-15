package com.example.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@RestController
@RequestMapping("/api/user-service")
public class UserController {

    @GetMapping("/")
    public String getDefault(){
        return "Hello from User Service ";
    }

    @GetMapping("/users")
    public String getHello(){
        return "I have 10 users ";
    }


}
