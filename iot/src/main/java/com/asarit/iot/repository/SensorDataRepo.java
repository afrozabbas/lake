package com.asarit.iot.repository;

import com.asarit.iot.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepo extends JpaRepository<SensorData,Long> {
    SensorData findByLakeId(Long lakeId);
}
