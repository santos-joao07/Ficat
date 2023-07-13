package com.example.ficat.controllers;

import com.example.ficat.dtos.AcademicUnityRecordDto;
import com.example.ficat.models.AcademicUnityModel;
import com.example.ficat.repositories.AcademicUnityRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AcademicUnityController {

    @Autowired
    AcademicUnityRepository academicUnityRepository;

    @PostMapping("/academicUnities")
    public ResponseEntity<AcademicUnityModel> saveAcademicUnity(@RequestBody @Valid AcademicUnityRecordDto academicUnityRecordDto) {
        var academicUnityModel = new AcademicUnityModel();
        BeanUtils.copyProperties(academicUnityRecordDto, academicUnityModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(academicUnityRepository.save(academicUnityModel));
    }

    @GetMapping("/academicUnities")
    public ResponseEntity<List<AcademicUnityModel>> getAllAcademicUnities() {
        return ResponseEntity.status(HttpStatus.OK).body(academicUnityRepository.findAll());
    }

    @GetMapping("/academicUnities/{id}")
    public ResponseEntity<Object> getOneAcademicUnity(@PathVariable(value="id")UUID id) {
        Optional<AcademicUnityModel> academicUnity0 = academicUnityRepository.findById(id);
        if(academicUnity0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instituto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(academicUnity0.get());
    }

    @PutMapping("/academicUnities/{id}")
    public ResponseEntity<Object> updateAcademicUnity(@PathVariable(value="id") UUID id,
                                                      @RequestBody @Valid AcademicUnityRecordDto academicUnityRecordDto) {
        Optional<AcademicUnityModel> academicUnity0 = academicUnityRepository.findById(id);
        if( academicUnity0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instituto não encontrado");
        }
        var academicUnityModel = academicUnity0.get();
        BeanUtils.copyProperties(academicUnityRecordDto, academicUnityModel);
        return ResponseEntity.status(HttpStatus.OK).body(academicUnityRepository.save(academicUnityModel));
    }

    @DeleteMapping("/academicUnities/{id}")
    public ResponseEntity<Object> deleteAcademicUnity(@PathVariable(value="id")UUID id) {
        Optional<AcademicUnityModel> academicUnity0 = academicUnityRepository.findById(id);
        if(academicUnity0.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instituto não encontrado");
        }
        academicUnityRepository.delete(academicUnity0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Instituto deletado com sucesso");
    }

}
