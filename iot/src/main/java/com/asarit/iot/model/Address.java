package com.asarit.iot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String area;
    private String doorNo;
    private String state;
    private String city;
    private Integer pinCode;
    @OneToOne
    @JoinColumn(name = "lake_id")
    private Lake lake;

    public Address(Long id, String street, String area, String doorNo, String state, String city, Integer pinCode) {
        this.id = id;
        this.street = street;
        this.area = area;
        this.doorNo = doorNo;
        this.state = state;
        this.city = city;
        this.pinCode = pinCode;
    }
}
