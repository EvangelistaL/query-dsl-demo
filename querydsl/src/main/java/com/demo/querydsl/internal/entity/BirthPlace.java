package com.demo.querydsl.internal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "birth_place")
public class BirthPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.DETACH ,CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)

    @JoinTable(
            name = "person_birth_place",
            joinColumns = @JoinColumn(name = "birth_place_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> persons;
}
