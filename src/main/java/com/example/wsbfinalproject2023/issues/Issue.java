package com.example.wsbfinalproject2023.issues;

import com.example.wsbfinalproject2023.projects.Project;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Issue {

    @ManyToOne (optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    private String code;
    private String title;
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueType type = IssueType.TASK;
    @Id
    @GeneratedValue
    private Long id;


}
