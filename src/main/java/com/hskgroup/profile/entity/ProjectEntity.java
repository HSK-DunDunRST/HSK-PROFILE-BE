package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "project_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    @Column(name = "project_uuid", nullable = false, unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID projectId;

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
