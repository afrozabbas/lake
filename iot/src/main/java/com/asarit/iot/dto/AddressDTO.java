package com.asarit.iot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private String street;
    private String area;
    private String doorNo;
    private String state;
    private String city;
    private Integer pinCode;
    private Long lakeId;
}
