package com.demo.querydsl.internal.controller;

import com.demo.querydsl.api.controller.PersonController;
import com.demo.querydsl.api.usecase.RetrievePersonByBornDate;
import com.demo.querydsl.api.usecase.RetrievePersonByName;
import com.demo.querydsl.api.usecase.RetrievePersonByNameAndBornDate;
import com.demo.querydsl.api.usecase.RetrievePersonsByStateName;
import com.demo.querydsl.internal.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class DefaultPersonController implements PersonController {

    private final RetrievePersonByBornDate retrievePersonByBornDate;

    private final RetrievePersonByName retrievePersonByName;

    private final RetrievePersonByNameAndBornDate retrievePersonByNameAndBornDate;

    private final RetrievePersonsByStateName retrievePersonsByStateName;


    @Override
    public Person retrievePersonByName(String personName) {
        return this.retrievePersonByName.execute(personName);
    }

    @Override
    public Person retrievePersonByNameAndBornDate(String personName, LocalDate bornDate) {
        return this.retrievePersonByNameAndBornDate.execute(personName, bornDate);
    }

    @Override
    public Person retrievePersonByBornDate(LocalDate bornDate) {
        return this.retrievePersonByBornDate.execute(bornDate);
    }

    @Override
    public Page<Person> retrievePersonByStateName(String stateName, Pageable pageable) {
        return this.retrievePersonsByStateName.execute(stateName, pageable);
    }
}
