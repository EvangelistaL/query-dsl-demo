package com.demo.querydsl.internal.usecase;

import com.demo.querydsl.api.specificaion.PersonSpecification;
import com.demo.querydsl.api.usecase.RetrievePersonByBornDate;
import com.demo.querydsl.internal.entity.Person;
import com.demo.querydsl.internal.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DefaultRetrievePersonByBornDate implements RetrievePersonByBornDate {

    private final PersonRepository personRepository;

    @Override
    public Person execute(LocalDate bornDate) {
        return this.personRepository.findOne(PersonSpecification.findByBirthDate(bornDate))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Person with born date %s not found", bornDate)));
    }
}
