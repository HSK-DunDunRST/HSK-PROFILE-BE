package com.hskgroup.profile.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String projectTitle;

    @Lob
    @Column(name = "description_name")
    private String projectDescription;

    @Column(name = "techstack_name", length = 255)
    private String techStackName;

    @Column(length = 255)
    private String link;
}
