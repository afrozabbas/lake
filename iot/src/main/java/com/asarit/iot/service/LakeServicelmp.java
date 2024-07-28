package com.asarit.iot.service;


import com.asarit.iot.dto.LakeDTO;
import com.asarit.iot.exceptions.LakeNotFoundException;
import com.asarit.iot.mapper.LakeMapper;
import com.asarit.iot.model.Lake;
import com.asarit.iot.repository.LakeRepo;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LakeServicelmp implements LakeService {
    private final LakeRepo lakeRepo;
    private final LakeMapper lakeMapper;

    public LakeServicelmp(LakeRepo lakeRepo, LakeMapper lakeMapper) {
        this.lakeRepo = lakeRepo;
        this.lakeMapper = lakeMapper;
    }

    @Override
    public LakeDTO register(LakeDTO lakeDTO) {
        Lake lakeFormDb= lakeRepo.save(lakeMapper.toLake(lakeDTO));
       return lakeMapper.toLakeDTO(lakeFormDb);
    }

    @Override
    public LakeDTO findLakeById(Long lakeId)throws LakeNotFoundException {
        Optional<Lake> lakeFromD = lakeRepo.findById(lakeId);
        if(lakeFromD.isEmpty()){
            throw new LakeNotFoundException("the give id with this "+ lakeId + " not found");
        }
      return  lakeMapper.toLakeDTO(lakeFromD.get());

    }

    @Override
    public LakeDTO updateLake(LakeDTO lakeDTO)throws  LakeNotFoundException{
        Optional<Lake> byId = lakeRepo.findById(lakeDTO.getId());
        if(byId.isEmpty()){
            throw new LakeNotFoundException("the give id with this "+ lakeDTO.getId() + " not found");
        }
        Lake lakeFormDb=byId.get();
        lakeFormDb.setName(lakeDTO.getName());
        lakeFormDb.setPoliceName1(lakeDTO.getPoliceName1());
        lakeFormDb.setPoliceName2(lakeDTO.getPoliceName2());
        lakeFormDb.setPoliceNumber1(lakeDTO.getPoliceNumber1());
        lakeFormDb.setPoliceNumber2(lakeDTO.getPoliceNumber2());
        lakeFormDb.setInChargeName(lakeDTO.getInChargeName());
        lakeFormDb.setInChargeNumber(lakeDTO.getInChargeNumber());

        return lakeMapper.toLakeDTO(lakeRepo.save(lakeFormDb));
    }

    @Override
    public void deleteById(Long lakeId) {
        lakeRepo.deleteById(lakeId);
    }

    @Override
    public List<LakeDTO> getAllLakes() {
        return lakeRepo.findAll().stream()
                .map(lake -> new LakeDTO(
                        lake.getId(),
                        lake.getName(),
                        lake.getPoliceName1(),
                        lake.getPoliceName2(),
                        lake.getPoliceNumber1(),
                        lake.getPoliceNumber2(),
                        lake.getInChargeName(),
                        lake.getInChargeNumber(),
                        lake.getAmount()
                ))
                .toList();



    }
}
