package com.asarit.iot.mapper;


import com.asarit.iot.dto.LakeDTO;
import com.asarit.iot.model.Lake;
import org.springframework.stereotype.Service;

@Service
public class LakeMapper {
   public Lake toLake(LakeDTO lakeDTO){
        return new Lake(
                lakeDTO.getId(),
                lakeDTO.getName(),
                lakeDTO.getPoliceName1(),
                lakeDTO.getPoliceName2(),
                lakeDTO.getPoliceNumber1(),
                lakeDTO.getPoliceNumber2(),
                lakeDTO.getInChargeName(),
                lakeDTO.getInChargeNumber(),
                lakeDTO.getAmount()
        );
    }

    public LakeDTO toLakeDTO(Lake lake) {
       return new LakeDTO(
               lake.getId(),
               lake.getName(),
               lake.getPoliceName1(),
               lake.getPoliceName2(),
               lake.getPoliceNumber1(),
               lake.getPoliceNumber2(),
               lake.getInChargeName(),
               lake.getInChargeNumber(),
               lake.getAmount()
       );
    }
}
