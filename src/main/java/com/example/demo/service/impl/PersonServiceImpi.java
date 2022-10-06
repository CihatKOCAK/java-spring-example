package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Person;
import com.example.demo.repo.AddressRepository;
import com.example.demo.repo.PersonRepository;
import com.example.demo.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpi implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository adressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        // Assert.isNotNull(personDto.getFirstName(), "First name is required");
        // Assert.isNotNull(personDto.getLastName(), "Last name is required");
        // get status required
        Assert.notNull(personDto.getStatus(), "Status is required");
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPhone(personDto.getPhone());
        person.setEmail(personDto.getEmail());
        person.setStatus(personDto.getStatus());
        final Person personDb = personRepository.save(person);
        List<Address> adressList = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            System.out.println(item);
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(
                    item.contains("home") ? Address.AddressType.HOME
                            : item.contains("work") ? Address.AddressType.WORK : Address.AddressType.OTHER);

            address.setStatus(true);
            address.setPerson(personDb);
            adressList.add(address);
        });
        adressRepository.saveAll(adressList);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public PersonDto update(PersonDto personDto) {
        Person person = personRepository.findById(personDto.getId()).get();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPhone(personDto.getPhone());
        person.setEmail(personDto.getEmail());
        person.setStatus(personDto.getStatus());
        personRepository.save(person);
        return personDto;
    }

    @Override
    public PersonDto delete(PersonDto personDto) {
        // user deleteById remove
        personRepository.deleteById(personDto.getId());
        return personDto;
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        personList.forEach(item -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setFirstName(item.getFirstName());
            personDto.setLastName(item.getLastName());
            personDto.setPhone(item.getPhone());
            personDto.setEmail(item.getEmail());
            personDto.setAddresses(
                    item.getAddressList().stream().map(item1 -> item1.getAddress()).collect(Collectors.toList()));
            personDtoList.add(personDto);
        });
        return personDtoList;
    }

}