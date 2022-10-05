package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Adress;
import com.example.demo.entity.Person;
import com.example.demo.repo.AdressRepository;
import com.example.demo.repo.PersonRepository;
import com.example.demo.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpi implements PersonService {

    private final PersonRepository personRepository;
    private final AdressRepository adressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Assert.isNull(personDto.getFirstName(), "First name is required");
        Assert.isNull(personDto.getLastName(), "Last name is required");
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPhone(personDto.getPhone());
        person.setEmail(personDto.getEmail());
        final Person personDb = personRepository.save(person);
        List<Adress> adressList = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Adress adress = new Adress();
            adress.setAdress(item);
            adress.setAdressType(Adress.AdressType.OTHER);
            adress.setStatus(true);
            adressList.add(adress);
        });
        adressRepository.saveAll(adressList);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public PersonDto update(PersonDto personDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PersonDto delete(PersonDto personDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PersonDto getById(PersonDto personDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        persons.forEach(item -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setFirstName(item.getFirstName());
            personDto.setLastName(item.getLastName());
            personDto.setPhone(item.getPhone());
            personDto.setEmail(item.getEmail());
            personDto.setAddresses(item.getAdressList().stream().map(Adress::getAdress).collect(Collectors.toList()));
            personDtos.add(personDto);

            System.out.println(item.getAdressList());
        });
        return personDtos;
    }

}