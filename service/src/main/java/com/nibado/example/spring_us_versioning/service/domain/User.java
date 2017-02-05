package com.nibado.example.spring_us_versioning.service.domain;

import lombok.Data;

@Data
public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String eMail;
}
