package com.hskgroup.profile.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/* 프로젝트 이력 조회 응답 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRes {
    private UUID projectId;
    private String projectTitle;
    private String projectDescription;
    private List<TechStackRes> techStacks;
    private String projectLink;
    private LocalDateTime lastUpdateDate;
}
