package com.asarit.iot.mapper;

import com.asarit.iot.dto.SensorConfigDTO;
import com.asarit.iot.model.SensorConfig;
import org.springframework.stereotype.Service;

@Service
public class SensorConfigMapper {

    public SensorConfig toSensorConfig(SensorConfigDTO sensorConfigDTO) {
        SensorConfig sensorConfig=new SensorConfig();
        sensorConfig.setPhSerialNo(sensorConfigDTO.getPhSerialNo());
        sensorConfig.setDoSerialNo(sensorConfigDTO.getDoSerialNo());
        sensorConfig.setPhPdf(sensorConfigDTO.getPhPdf());
        sensorConfig.setDoPdf(sensorConfigDTO.getDoPdf());
        sensorConfig.setPhAmount(sensorConfigDTO.getPhAmount());
        sensorConfig.setDoAmount(sensorConfigDTO.getDoAmount());
        return sensorConfig;
    }

    public SensorConfigDTO toSensorConfigDTO(SensorConfig sensorConfig) {

        return new SensorConfigDTO(
                sensorConfig.getLake().getId(),
                sensorConfig.getPhSerialNo(),
                sensorConfig.getDoSerialNo(),
                sensorConfig.getPhPdf(),
                sensorConfig.getDoPdf(),
                sensorConfig.getPhAmount(),
                sensorConfig.getDoAmount(),
                sensorConfig.getId()
        );
    }
}
