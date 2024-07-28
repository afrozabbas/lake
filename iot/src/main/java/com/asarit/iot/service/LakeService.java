package com.asarit.iot.service;


import com.asarit.iot.dto.LakeDTO;
import com.asarit.iot.exceptions.LakeNotFoundException;
import com.asarit.iot.model.Lake;

import java.util.List;

public interface LakeService {
    LakeDTO register(LakeDTO lakeDTO);

    LakeDTO findLakeById(Long lakeId)throws LakeNotFoundException;

    LakeDTO updateLake(LakeDTO lakeDTO)throws  LakeNotFoundException;

    void deleteById(Long lakeId);

    List<LakeDTO> getAllLakes();
}
