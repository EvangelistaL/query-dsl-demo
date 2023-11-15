package com.demo.querydsl.api.specificaion;

import com.demo.querydsl.internal.entity.QPerson;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class PersonSpecification {

    private static final QPerson qPerson = QPerson.person;

    public static Predicate findByName(String personName){
        return qPerson.name.contains(personName);
    }

    public static Predicate findByBirthDate(LocalDate birthDate){
        return qPerson.bornDate.eq(birthDate);
    }

    public static Predicate findByNameAndBirthDate(String personName, LocalDate birthDate){
        return qPerson.name.eq(personName).and(findByBirthDate(birthDate));
    }

    public static Predicate findPersonsByStateName(String stateName){
        return qPerson.birthPlace.any().state.eq(stateName);
    }
}
