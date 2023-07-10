package com.example.ficat.controllers;

import com.example.ficat.dtos.AcademicUnityRecordDto;
import com.example.ficat.models.AcademicUnityModel;
import com.example.ficat.repositories.AcademicUnityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
