package com.firstspring.demo.endpoints;

import org.springframework.stereotype.Component;

@Component
public class GreetingEndpoint {
    public String getGreeting(){
        return "Hello World from Actuator!";
    }
}
