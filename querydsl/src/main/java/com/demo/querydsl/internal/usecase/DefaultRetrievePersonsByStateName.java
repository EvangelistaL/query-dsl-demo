package com.demo.querydsl.internal.usecase;

import com.demo.querydsl.api.specification.PersonSpecification;
import com.demo.querydsl.api.usecase.RetrievePersonsByStateName;
import com.demo.querydsl.internal.entity.Person;
import com.demo.querydsl.internal.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultRetrievePersonsByStateName implements RetrievePersonsByStateName {

    private final PersonRepository personRepository;

    @Override
    public Page<Person> execute(String stateName, Pageable pageable) {
        return this.personRepository.findAll(PersonSpecification.findPersonsByStateName(stateName), pageable);
    }
}
