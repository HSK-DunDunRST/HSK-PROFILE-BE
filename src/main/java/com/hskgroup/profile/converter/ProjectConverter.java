package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.ProjectRes;
import com.hskgroup.profile.entity.ProjectEntity;

public class ProjectConverter {
    public static ProjectRes convertToProjectRes(ProjectEntity projectEntity) {
        return ProjectRes.builder()
                .projectTitle(projectEntity.getProjectTitle())
                .projectDescription(projectEntity.getProjectDescription())
                .projectLink(projectEntity.getProjectLink())
                .lastUpdateDate(projectEntity.getUpdatedAt())
                .build();
    }
}
