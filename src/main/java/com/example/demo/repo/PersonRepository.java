package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
