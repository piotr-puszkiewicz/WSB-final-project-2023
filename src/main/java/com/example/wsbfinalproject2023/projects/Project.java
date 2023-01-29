package com.example.wsbfinalproject2023.projects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity

public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String code;

    private String description;

    private Boolean enabled = true;

}
