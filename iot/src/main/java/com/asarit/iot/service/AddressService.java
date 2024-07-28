package com.asarit.iot.service;


import com.asarit.iot.dto.AddressDTO;

public interface AddressService {
    void save(AddressDTO addressDTO);

    AddressDTO getByLakeId(Long lakeId);
}
