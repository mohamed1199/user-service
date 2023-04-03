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
        return "Hello from User Service - " + getAddress() ;
    }

    @GetMapping("/users")
    public String getHello(){
        return "I have 10 users - " +  getAddress() ;
    }

    public String getAddress(){
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("google.com", 80));
            return socket.getLocalAddress().getHostAddress();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
