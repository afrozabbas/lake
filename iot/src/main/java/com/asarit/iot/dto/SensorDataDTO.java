package com.asarit.iot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDataDTO {
    private Long id;
    private Double phValue;
    private Double doValue;
    private Long lakeId;
}
