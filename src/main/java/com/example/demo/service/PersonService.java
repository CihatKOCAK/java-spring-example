package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.dto.PersonDto;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    PersonDto update(PersonDto personDto);

    PersonDto delete(PersonDto personDto);

    PersonDto getById(PersonDto personDto);

    List<PersonDto> getAll(Pageable pageable);

}
