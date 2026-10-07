package com.oms.backend;

public class CustomerDTO {
    private String name;
    private String emailAddress;

    public CustomerDTO(String fullName, String emailAddress) {
        this.name = fullName;
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
