package com.example.spring_boot_project_struct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDto {
    private String country;
    private String city;
    private String street ;



}
