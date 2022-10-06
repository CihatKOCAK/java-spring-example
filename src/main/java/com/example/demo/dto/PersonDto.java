package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private List<String> addresses;
}


