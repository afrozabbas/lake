package com.asarit.iot.service;

import com.asarit.iot.dto.SensorConfigDTO;
import com.asarit.iot.mapper.SensorConfigMapper;
import com.asarit.iot.model.Lake;
import com.asarit.iot.model.SensorConfig;
import com.asarit.iot.repository.LakeRepo;
import com.asarit.iot.repository.SensorConfigRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SensorConfigServicelmp implements SensorConfigService {
    private final LakeRepo lakeRepo;
    private final SensorConfigMapper sensorConfigMapper;
    private final SensorConfigRepo sensorConfigRepo;


    public SensorConfigServicelmp(LakeRepo lakeRepo, SensorConfigMapper sensorConfigMapper, SensorConfigRepo sensorConfigRepo) {
        this.lakeRepo = lakeRepo;
        this.sensorConfigMapper = sensorConfigMapper;
        this.sensorConfigRepo = sensorConfigRepo;
    }

    @Override
    public void saveSensorConfig(SensorConfigDTO sensorConfigDTO) {
        Lake lakeFromDb=lakeRepo.findById(sensorConfigDTO.getLakeId()).get();
        SensorConfig sensorConfig=sensorConfigMapper.toSensorConfig(sensorConfigDTO);
        sensorConfig.setLake(lakeFromDb);
        sensorConfigRepo.save(sensorConfig);



    }

    @Override
    public List<SensorConfigDTO> getAllSensorConfig(Long lakeId) {
        List<SensorConfig> sensorConfigs=sensorConfigRepo.findByLakeId(lakeId);
        List<SensorConfigDTO> sensorConfigDTOS=new ArrayList<SensorConfigDTO>();
        for (int i = 0; i < sensorConfigs.size(); i++) {
            sensorConfigDTOS.add(sensorConfigMapper.toSensorConfigDTO(sensorConfigs.get(i)));
        }
        return sensorConfigDTOS;
    }

    @Override
    public SensorConfigDTO findBySensorConfigId(Long sensorConfigId) {
        System.out.println(sensorConfigId);
        SensorConfig sensorConfigFromDB= sensorConfigRepo.findById(sensorConfigId).get();
        System.out.println(sensorConfigFromDB.getId());
        return sensorConfigMapper.toSensorConfigDTO(sensorConfigFromDB);
    }
}
