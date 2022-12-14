package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PersonDto;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    PersonDto update(PersonDto personDto);

    PersonDto delete(PersonDto personDto);

    List<PersonDto> getAll();

}
