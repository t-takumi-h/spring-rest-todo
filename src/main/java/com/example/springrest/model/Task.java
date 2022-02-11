package com.example.springrest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private Boolean completed = false;
}
