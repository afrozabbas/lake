package com.asarit.iot.controller;

import com.asarit.iot.dto.SensorDataDTO;
import com.asarit.iot.mapper.SensorDataMapper;
import com.asarit.iot.model.SensorData;
import com.asarit.iot.service.SensorDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensor/")
public class SensorDataController {
    private final SensorDataService sensorDataService;


    public SensorDataController(SensorDataService sensorDataService, SensorDataMapper sensorDataMapper) {
        this.sensorDataService = sensorDataService;

    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody SensorDataDTO sensorDataDTO) {
        sensorDataService.register(sensorDataDTO);
        return ResponseEntity.status(HttpStatus.OK).body("registered");
    }

    @GetMapping("getByLakeId/{lakeId}")
    public SensorDataDTO getByLakeId(@PathVariable("lakeId") Long lakeId) {
        return sensorDataService.getByLakeId(lakeId);

    }

  @PutMapping("updateByLakeId/{lakeId}")
    public ResponseEntity updateByLakeId(@RequestBody SensorDataDTO sensorDataDTO){
        sensorDataService.updateByLakeId(sensorDataDTO);
        return ResponseEntity.status(HttpStatus.OK).body("upadted");
  }
}
