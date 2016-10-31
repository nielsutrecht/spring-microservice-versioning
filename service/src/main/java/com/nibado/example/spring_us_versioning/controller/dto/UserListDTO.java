package com.nibado.example.spring_us_versioning.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserListDTO {
    private final List<UserDTO> users;
}
