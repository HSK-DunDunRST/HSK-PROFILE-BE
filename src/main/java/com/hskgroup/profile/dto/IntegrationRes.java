package com.hskgroup.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntegrationRes {
    private List<ProfileRes> profileList;
    private List<EducationRes> educationList;
    private List<CertificationRes> certificationList;
    private List<ProjectRes> projectList;
}
