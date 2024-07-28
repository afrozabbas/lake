package com.asarit.iot.service;

import com.asarit.iot.dto.SensorDataDTO;
import com.asarit.iot.mapper.SensorDataMapper;
import com.asarit.iot.model.Lake;
import com.asarit.iot.model.SensorData;
import com.asarit.iot.repository.LakeRepo;
import com.asarit.iot.repository.SensorDataRepo;
import org.springframework.stereotype.Service;

@Service
public class SensorDataServicelmp implements SensorDataService{
    private final LakeRepo lakeRepo;
    private final SensorDataMapper sensorDataMapper;
    private final SensorDataRepo sensorDataRepo;


    public SensorDataServicelmp(LakeRepo lakeRepo, SensorDataMapper sensorDataMapper, SensorDataRepo sensorDataRepo) {
        this.lakeRepo = lakeRepo;
        this.sensorDataMapper = sensorDataMapper;
        this.sensorDataRepo = sensorDataRepo;
    }



    @Override
    public void register(SensorDataDTO sensorDataDTO) {
        Lake lakeFromDb=lakeRepo.findById(sensorDataDTO.getLakeId()).get();
        SensorData sensorData=sensorDataMapper.toSensorData(sensorDataDTO);
        sensorData.setLake(lakeFromDb);
        sensorDataRepo.save(sensorData);

    }

    @Override
    public SensorDataDTO getByLakeId(Long lakeId) {
        SensorData sensorData=sensorDataRepo.findByLakeId(lakeId);
        return sensorDataMapper.toSensorDataDTO(sensorData);
    }

    @Override
    public void updateByLakeId(SensorDataDTO sensorDataDTO) {
        SensorData sensorData=sensorDataRepo.findByLakeId(sensorDataDTO.getLakeId());
        sensorData.setPhValue(sensorDataDTO.getPhValue());
        sensorData.setDoValue(sensorDataDTO.getDoValue());
        sensorDataRepo.save(sensorData);
    }
}
