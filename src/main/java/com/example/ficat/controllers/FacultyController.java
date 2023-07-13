package com.example.ficat.controllers;

import com.example.ficat.dtos.FacultyRecordDto;
import com.example.ficat.models.FacultyModel;
import com.example.ficat.repositories.FacultyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/faculties")
    public ResponseEntity<List<FacultyModel>> getAllFaculties() {
        return ResponseEntity.status(HttpStatus.OK).body(facultyRepository.findAll());
    }

    @GetMapping("faculties/{id}")
    public ResponseEntity<Object> getOneFaculty(@PathVariable(value="id")UUID id) {
        Optional<FacultyModel> faculty0 = facultyRepository.findById(id);
        if(faculty0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculdade não encotrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(faculty0.get());
    }

    @PutMapping("/faculties/{id}")
    public ResponseEntity<Object> updateFaculty(@PathVariable(value="id")UUID id,
                                                @RequestBody @Valid FacultyRecordDto facultyRecordDto) {
        Optional<FacultyModel> faculty0 = facultyRepository.findById(id);
        if(faculty0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculdade não encontrada");
        }
        var facultyModel = faculty0.get();
        BeanUtils.copyProperties(facultyRecordDto, facultyModel);
        return ResponseEntity.status(HttpStatus.OK).body(facultyRepository.save(facultyModel));
    }

    @DeleteMapping("/faculties/{id}")
    public ResponseEntity<Object> deleteFaculty(@PathVariable("id")UUID id) {
        Optional<FacultyModel> faculty0 = facultyRepository.findById(id);
        if(faculty0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculdade não encontrada");
        }
        facultyRepository.delete(faculty0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Faculdade deletada com sucesso");
    }
}
