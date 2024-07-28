package com.asarit.iot.controller;

import com.asarit.iot.dto.SensorConfigDTO;
import com.asarit.iot.model.SensorConfig;
import com.asarit.iot.service.SensorConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensorConfig/")
public class SensorConfigController {
    private final SensorConfigService sensorConfigService;

    public SensorConfigController( SensorConfigService sensorConfigService) {
        this.sensorConfigService = sensorConfigService;
    }

    @PostMapping("save")
   public ResponseEntity<String> saveSensorConfig(@RequestBody SensorConfigDTO sensorConfigDTO){
        sensorConfigService.saveSensorConfig(sensorConfigDTO);
     return ResponseEntity.status(HttpStatus.CREATED).body("saved");
    }

    @GetMapping("getAllSensorConfigByLakeId/{lakeId}")
    public List<SensorConfigDTO> getAllSensorConfigByLakeId(@PathVariable("lakeId") Long lakeId){
        return sensorConfigService.getAllSensorConfig(lakeId);
    }

    @GetMapping("getById/{sensorConfigId}")
   public SensorConfigDTO getBySendorConfigDetails(@PathVariable("sensorConfigId") Long SensorConfigId){
        return sensorConfigService.findBySensorConfigId(SensorConfigId);
    }

}
