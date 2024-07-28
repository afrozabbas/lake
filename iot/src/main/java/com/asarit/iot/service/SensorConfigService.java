package com.asarit.iot.service;

import com.asarit.iot.dto.SensorConfigDTO;
import com.asarit.iot.model.SensorConfig;

import java.util.List;
import java.util.Optional;

public interface SensorConfigService {
    void saveSensorConfig(SensorConfigDTO sensorConfigDTO);

    List<SensorConfigDTO> getAllSensorConfig(Long lakeId);

    SensorConfigDTO findBySensorConfigId(Long sensorConfigId);
}
