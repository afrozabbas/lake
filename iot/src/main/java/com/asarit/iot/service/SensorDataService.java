package com.asarit.iot.service;

import com.asarit.iot.dto.SensorDataDTO;
import com.asarit.iot.model.SensorData;

public interface SensorDataService {


    void register(SensorDataDTO sensorDataDTO);

    SensorDataDTO getByLakeId(Long lakeId);

    void updateByLakeId(SensorDataDTO sensorDataDTO);
}
