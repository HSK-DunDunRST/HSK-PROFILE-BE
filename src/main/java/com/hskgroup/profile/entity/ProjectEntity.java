package com.hskgroup.profile.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "project_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_title", length = 200, nullable = false)
    private String projectTitle;

    @Lob
    @Column(name = "description_name", nullable = false)
    private String projectDescription;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "project_techstack",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "techstack_id")
    )
    private List<TechStackEntity> techStacks;

    @Column(name = "project_link", nullable = false)
    private String projectLink;
}
