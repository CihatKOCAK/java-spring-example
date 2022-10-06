package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.example.demo.dto.PersonDto;
import com.example.demo.service.PersonService;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @PutMapping
    public ResponseEntity<PersonDto> update(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.update(personDto));
    }

    @DeleteMapping
    public ResponseEntity<PersonDto> delete(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.delete(personDto));
    }
    
}