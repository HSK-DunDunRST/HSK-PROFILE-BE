package com.hskgroup.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 학력 정보 조회 응답 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationRes {
    private String schoolName;
    private String majorName;
    private String educationPeriod;
    private String educationStatus;
}