package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.ProjectRes;
import com.hskgroup.profile.entity.ProjectEntity;
import com.hskgroup.profile.entity.TechStackEntity;

import java.util.List;

public class ProjectConverter {
    public static ProjectRes convertToProjectRes(ProjectEntity projectEntity) {
    List<TechStackEntity> safeTechStackList = projectEntity.getTechStacks() == null
                ? List.of()
                : List.copyOf(projectEntity.getTechStacks());

        return ProjectRes.builder()
                .projectTitle(projectEntity.getProjectTitle())
                .projectDescription(projectEntity.getProjectDescription())
        .techStacks(safeTechStackList)
                .projectLink(projectEntity.getProjectLink())
                .lastUpdateDate(projectEntity.getUpdatedAt())
                .build();
    }
}
