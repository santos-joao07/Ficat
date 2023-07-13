package com.example.ficat.controllers;

import com.example.ficat.dtos.CityRecordDto;
import com.example.ficat.models.CityModel;
import com.example.ficat.repositories.CityRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @PostMapping("/cities")
    public ResponseEntity<?> saveCity(@RequestBody @Valid CityRecordDto cityRecordDto, BindingResult bindingResult) {
        ResponseEntity<?> errorMessage = ErrorController.getResponseEntity(bindingResult);
        if (errorMessage != null) return errorMessage;

        if (cityRepository.existsByName(cityRecordDto.name())) {
            String nameDuplicated = "O nome da cidade já existe";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nameDuplicated);
        }

        var cityModel = new CityModel();
        BeanUtils.copyProperties(cityRecordDto, cityModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cityRepository.save(cityModel));
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityModel>> getAllCities() {
        return ResponseEntity.status(HttpStatus.OK).body(cityRepository.findAll());
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<Object> getOneCity(@PathVariable(value="id") UUID id) {
        Optional<CityModel> city0 = cityRepository.findById(id);
        if(city0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(city0.get());
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<Object> updateCity(@PathVariable(value="id") UUID id,
                                             @RequestBody @Valid CityRecordDto cityRecordDto) {
        Optional<CityModel> city0 = cityRepository.findById(id);
        if(city0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada");
        }
        var cityModel = city0.get();
        BeanUtils.copyProperties(cityRecordDto, cityModel);
        return ResponseEntity.status(HttpStatus.OK).body(cityRepository.save(cityModel));
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<Object> deleteCity(@PathVariable(value="id")UUID id) {
        Optional<CityModel> city0 = cityRepository.findById(id);
        if(city0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada");
        }
        cityRepository.delete(city0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cidade deletada com sucesso");
    }

}
