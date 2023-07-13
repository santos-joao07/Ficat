package com.example.ficat.controllers;

import com.example.ficat.dtos.CourseRecordDto;
import com.example.ficat.models.CourseModel;
import com.example.ficat.repositories.CourseRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/courses")
    public ResponseEntity<CourseModel> saveCourse(@RequestBody @Valid CourseRecordDto courseRecordDto) {
        var courseModel = new CourseModel();
        BeanUtils.copyProperties(courseRecordDto, courseModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(courseModel));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseModel>> getAllCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(courseRepository.findAll());
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Object> getOneCourse(@PathVariable(value="id")UUID id) {
        Optional<CourseModel> course0 = courseRepository.findById(id);
        if(course0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(course0.get());
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable(value="id")UUID id,
                                               @RequestBody @Valid CourseRecordDto courseRecordDto) {
        Optional<CourseModel> course0 = courseRepository.findById(id);
        if(course0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encotrado");
        }
        var courseModel = course0.get();
        BeanUtils.copyProperties(courseRecordDto, courseModel);
        return ResponseEntity.status(HttpStatus.OK).body(courseRepository.save(courseModel));
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable(value="id")UUID id) {
        Optional<CourseModel> course0 = courseRepository.findById(id);
        if(course0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        courseRepository.delete(course0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso");
    }


}
