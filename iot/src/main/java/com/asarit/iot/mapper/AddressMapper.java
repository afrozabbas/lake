package com.asarit.iot.mapper;


import com.asarit.iot.dto.AddressDTO;
import com.asarit.iot.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {
   public Address toAddress(AddressDTO addressDTO){
        return new Address(
                addressDTO.getId(),
                addressDTO.getStreet(),
                addressDTO.getArea(),
                addressDTO.getDoorNo(),
                addressDTO.getState(),
                addressDTO.getCity(),
                addressDTO.getPinCode()
        );
    }

    public AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(
               address.getId(),
                address.getStreet(),
                address.getArea(),
                address.getDoorNo(),
                address.getState(),
                address.getCity(),
                address.getPinCode(),
                address.getLake().getId()
       );
    }
}
