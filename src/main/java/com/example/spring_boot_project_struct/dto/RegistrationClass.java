package com.example.spring_boot_project_struct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegistrationClass {
    private String name;
    private String email;
    private String password;
}
