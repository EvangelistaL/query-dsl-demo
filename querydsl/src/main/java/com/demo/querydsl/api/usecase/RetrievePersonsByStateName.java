package com.demo.querydsl.api.usecase;

import com.demo.querydsl.internal.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrievePersonsByStateName {

    Page<Person> execute(String stateName, Pageable pageable);
}
