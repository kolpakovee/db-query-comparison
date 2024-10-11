package ru.kolpakovee.querydsldemoproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Employee> employees;
}
