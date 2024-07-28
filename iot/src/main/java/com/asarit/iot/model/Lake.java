package com.asarit.iot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String policeName1;
    private String policeName2;
    private String policeNumber1;
    private String policeNumber2;
    private String inChargeName;
    private String inChargeNumber;
    private Double amount;
    @OneToMany(mappedBy = "lake")
    private List<SensorConfig> sensorConfig;

    public Lake(Long id, String name, String policeName1, String policeName2, String policeNumber1, String policeNumber2, String inChargeName, String inChargeNumber, Double amount) {
        this.id = id;
        this.name = name;
        this.policeName1 = policeName1;
        this.policeName2 = policeName2;
        this.policeNumber1 = policeNumber1;
        this.policeNumber2 = policeNumber2;
        this.inChargeName = inChargeName;
        this.inChargeNumber = inChargeNumber;
        this.amount = amount;
    }
}
