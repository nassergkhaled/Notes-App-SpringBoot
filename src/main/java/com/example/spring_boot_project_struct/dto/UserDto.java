package com.example.spring_boot_project_struct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private List<AddressDto> addresses ;

}
