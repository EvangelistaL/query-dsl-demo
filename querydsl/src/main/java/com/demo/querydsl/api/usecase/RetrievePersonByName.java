package com.demo.querydsl.api.usecase;

import com.demo.querydsl.internal.entity.Person;

public interface RetrievePersonByName {

    Person execute(String personName);
}
