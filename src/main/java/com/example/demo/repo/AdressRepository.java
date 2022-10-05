package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Adress;

public interface AdressRepository extends JpaRepository<Adress, Long> {

}
