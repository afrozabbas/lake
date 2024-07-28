package com.asarit.iot.repository;


import com.asarit.iot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
    Address findByLakeId(Long lakeId);
}
