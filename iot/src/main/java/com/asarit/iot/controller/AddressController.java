package com.asarit.iot.controller;


import com.asarit.iot.dto.AddressDTO;

import com.asarit.iot.dto.LakeDTO;
import com.asarit.iot.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address/")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("save")
    public ResponseEntity<String> addresSave(@RequestBody AddressDTO addressDTO){
        addressService.save(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registered");
    }
    @GetMapping("getByLakeId/{lakeId}")
    public AddressDTO getByLakeId(@PathVariable("lakeId") Long lakeId){
        return addressService.getByLakeId(lakeId);
    }
}
