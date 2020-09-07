package com.example.stealth101.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;

    @NotBlank
    @NonNull
    @Column
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }


    // Without this getter, when you make a get request, it wont be included
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
