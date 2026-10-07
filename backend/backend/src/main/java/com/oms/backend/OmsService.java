package com.oms.backend;

import org.springframework.stereotype.Service;

@Service
public class OmsService {

    public String getWelcomeMessage(String name) {
        return "Welcome to the OMS, " + name + "!";
    }

    public CustomerDTO getCustomerProfile(String name) {
        if (name.equalsIgnoreCase("Unknown")) {
            throw new ResourceNotFoundException("Customer with name '" + name + "' not exists.");
        }
        String safeEmail = name.toLowerCase() + "@oms.com";
        return new CustomerDTO(name, safeEmail);
    }
}