package com.example.spring_boot_project_struct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContactsDto {
    private String contactName ;
    private String mobile ;

}
