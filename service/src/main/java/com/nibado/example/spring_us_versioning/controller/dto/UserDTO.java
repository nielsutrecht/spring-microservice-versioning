package com.nibado.example.spring_us_versioning.controller.dto;

import com.nibado.example.spring_us_versioning.versioning.Versioned;
import lombok.Data;

@Data
public class UserDTO implements Versioned {
    private final String firstName;
    private final String lastName;
    private final String eMail;

    @Override
    public Versioned toVersion(int version) {
        if (version <= 2) {
            return new UserDTOv2(firstName, lastName)
                    .toVersion(version);
        } else {
            return this;
        }
    }
}
