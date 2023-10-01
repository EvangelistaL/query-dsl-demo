package com.demo.querydsl.internal.entity;

import com.querydsl.core.annotations.QueryEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "born_date")
    private LocalDate bornDate;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH ,CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "person_id")
    private BirthPlace birthPlace;
}
