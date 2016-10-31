package com.nibado.example.spring_us_versioning.controller.dto;

import com.nibado.example.spring_us_versioning.versioning.Versioned;
import lombok.Data;

@Data
public class UserDTOv2 implements Versioned {
    private final String firstName;
    private final String lastName;

    @Override
    public Versioned toVersion(int version) {
        if(version <= 1) {
            return new UserDTOv1(firstName + " " + lastName);
        }
        else {
            return this;
        }
    }
}
