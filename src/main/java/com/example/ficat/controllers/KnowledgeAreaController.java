package com.example.ficat.controllers;

import com.example.ficat.dtos.KnowledgeAreaRecordDto;
import com.example.ficat.models.KnowledgeAreaModel;
import com.example.ficat.repositories.KnowledgeAreaRepository;
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
public class KnowledgeAreaController {

    @Autowired
    KnowledgeAreaRepository knowledgeAreaRepository;

    @PostMapping("/knowledgeAreas")
    public ResponseEntity<KnowledgeAreaModel> saveKnowledgeArea(@RequestBody @Valid KnowledgeAreaRecordDto knowledgeAreaRecordDto){
        var knowledgeAreaModel = new KnowledgeAreaModel();
        BeanUtils.copyProperties(knowledgeAreaRecordDto, knowledgeAreaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(knowledgeAreaRepository.save(knowledgeAreaModel));
    }

    @GetMapping("/knowledgeAreas")
    public ResponseEntity<List<KnowledgeAreaModel>> getAllKnowledgeAreas() {
        return ResponseEntity.status(HttpStatus.OK).body(knowledgeAreaRepository.findAll());
    }

    @GetMapping("/knowledgeAreas/{id}")
    public ResponseEntity<Object> getOneKnowledgeArea(@PathVariable(value="id")UUID id) {
        Optional<KnowledgeAreaModel> knowledgeArea0 = knowledgeAreaRepository.findById(id);
        if (knowledgeArea0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Área deconhecimento não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(knowledgeArea0.get());
    }
}
