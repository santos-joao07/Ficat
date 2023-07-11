package com.example.ficat.controllers;

import com.example.ficat.dtos.CourseRecordDto;
import com.example.ficat.models.CourseModel;
import com.example.ficat.repositories.CourseRepository;
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

}
