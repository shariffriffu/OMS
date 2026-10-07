package com.oms.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private OmsService omsService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Order Management System!";
    }

    @GetMapping("/greet/{name}")
    public Map<String, String> greetUser(@PathVariable String name) {
        Map<String, String> response = new HashMap<>();

        // Ask the Service to do the work
        String message = omsService.getWelcomeMessage(name);

        response.put("message", message);
        response.put("status", "SUCCESS");
        return response;
    }

    @GetMapping("/customer/{name}")
    public CustomerDTO getCustomer(@PathVariable String name) {
        return omsService.getCustomerProfile(name);
    }
}