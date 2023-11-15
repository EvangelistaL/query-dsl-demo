package com.demo.querydsl.internal.usecase;

import com.demo.querydsl.api.specificaion.PersonSpecification;
import com.demo.querydsl.api.usecase.RetrievePersonByName;
import com.demo.querydsl.internal.entity.Person;
import com.demo.querydsl.internal.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrievePersonByName implements RetrievePersonByName {

    private final PersonRepository personRepository;

    @Override
    public Person execute(String personName) {
        return this.personRepository.findOne(PersonSpecification.findByName(personName))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Person with name %s not found", personName)));
    }
}
