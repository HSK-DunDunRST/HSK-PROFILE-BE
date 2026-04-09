package com.hskgroup.profile.dto;

import com.hskgroup.profile.entity.TechStackEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/* 프로젝트 이력 조회 응답 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRes {
    private String projectTitle;
    private String projectDescription;
    private List<TechStackEntity> techStacks;
    private String projectLink;
    private LocalDateTime lastUpdateDate;
}
