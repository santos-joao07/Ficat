package com.example.ficat.controllers;

import com.example.ficat.dtos.FacultyRecordDto;
import com.example.ficat.models.FacultyModel;
import com.example.ficat.repositories.FacultyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacultyController {

    @Autowired
    FacultyRepository facultyRepository;

    @PostMapping("/faculties")
    public ResponseEntity<FacultyModel> saveFaculty(@RequestBody @Valid FacultyRecordDto facultyRecordDto) {
        var facultyModel = new FacultyModel();
        BeanUtils.copyProperties(facultyRecordDto, facultyModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(facultyRepository.save(facultyModel));
    }
}
