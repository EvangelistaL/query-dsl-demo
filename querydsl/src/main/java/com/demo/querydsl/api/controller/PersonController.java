package com.demo.querydsl.api.controller;

import com.demo.querydsl.internal.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/persons")
public interface PersonController {

    @GetMapping(path = "/{personName}")
    @ResponseStatus(HttpStatus.OK)
    Person retrievePersonByName(@PathVariable String personName);

    @GetMapping(path = "/{personName}/{bornDate}")
    @ResponseStatus(HttpStatus.OK)
    Person retrievePersonByNameAndBornDate(@PathVariable String personName, @PathVariable LocalDate bornDate);

    @GetMapping(path = "/{bornDate}")
    @ResponseStatus(HttpStatus.OK)
    Person retrievePersonByBornDate(@PathVariable LocalDate bornDate);

    @GetMapping(path = "/{stateName}")
    @ResponseStatus(HttpStatus.OK)
    Page<Person> retrievePersonByStateName(@PathVariable String stateName, Pageable pageable);
}
