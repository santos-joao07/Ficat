package com.example.ficat.controllers;

import com.example.ficat.dtos.CityRecordDto;
import com.example.ficat.models.CityModel;
import com.example.ficat.repositories.CityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @PostMapping("/cities")
    public ResponseEntity<CityModel> saveCity(@RequestBody @Valid CityRecordDto cityRecordDto) {
        var cityModel = new CityModel();
        BeanUtils.copyProperties(cityRecordDto, cityModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cityRepository.save(cityModel));
    }
}
