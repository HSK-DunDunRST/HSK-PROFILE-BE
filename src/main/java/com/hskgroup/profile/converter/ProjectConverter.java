package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.res.ProjectRes;
import com.hskgroup.profile.dto.res.TechStackRes;
import com.hskgroup.profile.entity.ProjectEntity;

import java.util.List;

public class ProjectConverter {
    public static ProjectRes convertToProjectRes(ProjectEntity projectEntity) {
        List<TechStackRes> safeTechStackList = projectEntity.getTechStacks() == null
                ? List.of()
                : projectEntity.getTechStacks().stream()
                        .map(TechStackConverter::convertToTechStackRes)
                        .toList();

        return ProjectRes.builder()
                .projectTitle(projectEntity.getProjectTitle())
                .projectDescription(projectEntity.getProjectDescription())
                .techStacks(safeTechStackList)
                .projectLink(projectEntity.getProjectLink())
                .lastUpdateDate(projectEntity.getUpdatedAt())
                .build();
    }
}
