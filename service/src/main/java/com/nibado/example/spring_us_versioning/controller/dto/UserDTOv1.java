package com.nibado.example.spring_us_versioning.controller.dto;

import com.nibado.example.spring_us_versioning.versioning.Versioned;
import lombok.Data;

@Data
public class UserDTOv1 implements Versioned {
    private final String name;

    @Override
    public Versioned toVersion(int version) {
        return this;
    }
}
