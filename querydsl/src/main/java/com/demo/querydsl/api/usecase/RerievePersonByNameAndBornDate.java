package com.demo.querydsl.api.usecase;

import com.demo.querydsl.internal.entity.Person;

import java.time.LocalDate;

public interface RerievePersonByNameAndBornDate {

    Person execute(String personName, LocalDate bornDate);
}
