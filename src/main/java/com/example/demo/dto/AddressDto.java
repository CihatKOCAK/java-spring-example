package com.example.demo.dto;

import com.example.demo.entity.Address.AddressType;

import lombok.Data;

public class AddressDto {

   @Data
    public static class AddressRequest {
         private String address;
         private Boolean status;
         private AddressType addressType;
    }
}
