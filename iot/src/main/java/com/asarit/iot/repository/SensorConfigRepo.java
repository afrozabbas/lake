package com.asarit.iot.repository;

import com.asarit.iot.dto.SensorConfigDTO;
import com.asarit.iot.model.SensorConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SensorConfigRepo extends JpaRepository<SensorConfig,Long> {
    List<SensorConfig> findByLakeId(Long lakeId);
}
