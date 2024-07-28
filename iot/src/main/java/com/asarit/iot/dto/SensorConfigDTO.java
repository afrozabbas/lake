package com.asarit.iot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorConfigDTO {
    private Long lakeId;
    private String phSerialNo;
    private String doSerialNo;
    private String phPdf;
    private String doPdf;
    private Double phAmount;
    private Double doAmount;
    private Long id;

}
