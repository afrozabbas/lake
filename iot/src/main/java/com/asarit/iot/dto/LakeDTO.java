package com.asarit.iot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LakeDTO {
    private Long id;
    private String name;
    private String policeName1;
    private String policeName2;
    private String policeNumber1;
    private String policeNumber2;
    private String inChargeName;
    private String inChargeNumber;
    private Double amount;

}
