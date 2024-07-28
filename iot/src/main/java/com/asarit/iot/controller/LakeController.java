package com.asarit.iot.controller;
import com.asarit.iot.dto.LakeDTO;
import com.asarit.iot.exceptions.LakeNotFoundException;
import com.asarit.iot.model.Lake;
import com.asarit.iot.service.LakeService;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lake/")
public class LakeController {
    private final LakeService lakeService;

    public LakeController(LakeService lakeService) {
        this.lakeService = lakeService;
    }

    @PostMapping("register")
    public ResponseEntity<LakeDTO> register(@RequestBody LakeDTO lakeDTO){
     return ResponseEntity.status(HttpStatus.CREATED).body(lakeService.register(lakeDTO));
    }


    @GetMapping("getById/{lakeId}")
    public ResponseEntity<?> getLakeDetails(@PathVariable("lakeId") Long lakeId){
        try {
            LakeDTO lakeById = lakeService.findLakeById(lakeId);//throw LakeNotFoundException
            return ResponseEntity.status(HttpStatus.OK).body(lakeById);
        }catch (LakeNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(e.getMessage()));
        }
    }


    @PutMapping("updateLake")
    public  ResponseEntity<?> updateLake(@RequestBody LakeDTO lakeDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(lakeService.updateLake(lakeDTO));
        } catch (LakeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(e.getMessage()));
        }

    }
//        @DeleteMapping("deleteById/{lakeId}")
//        public ResponseEntity deleteById(@PathVariable("lakeId") Long lakeId){
//            lakeService.deleteById(lakeId);
//            return   ResponseEntity.status(HttpStatus.OK).body("Deleted");
//        }
        @GetMapping("getAllLakes")
        public List<LakeDTO> getAllLakes(){
       return lakeService.getAllLakes();

        }


}
