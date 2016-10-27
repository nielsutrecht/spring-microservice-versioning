package com.nibado.example.spring_us_versioning.service.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private final UUID id;
    private final String firstName;
    private final String lastName;
}
