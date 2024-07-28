package com.asarit.iot.service;


import com.asarit.iot.dto.AddressDTO;
import com.asarit.iot.mapper.AddressMapper;
import com.asarit.iot.model.Address;
import com.asarit.iot.repository.AddressRepo;
import com.asarit.iot.repository.LakeRepo;
import org.springframework.stereotype.Service;

@Service
public class AddressServicelmp implements AddressService{
    private final AddressMapper addressMapper;
    private final LakeRepo lakeRepo;
    private final AddressRepo addressRepo;

    public AddressServicelmp(AddressMapper addressMapper, LakeRepo lakeRepo, AddressRepo addressRepo) {
        this.addressMapper = addressMapper;
        this.lakeRepo = lakeRepo;
        this.addressRepo = addressRepo;
    }

    @Override
    public void save(AddressDTO addressDTO) {
       Address address=addressMapper.toAddress(addressDTO);

       address.setLake(lakeRepo.findById(addressDTO.getLakeId()).get());
       addressRepo.save(address);

    }

    @Override
    public AddressDTO getByLakeId(Long lakeId) {
        Address addressFormDb=addressRepo.findByLakeId(lakeId);

        return addressMapper.toAddressDTO(addressFormDb);
    }
}
