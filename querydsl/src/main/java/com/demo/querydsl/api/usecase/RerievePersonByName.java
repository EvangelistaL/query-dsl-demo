package com.demo.querydsl.api.usecase;

import com.demo.querydsl.internal.entity.Person;

public interface RerievePersonByName {

    Person execute(String personName);
}
