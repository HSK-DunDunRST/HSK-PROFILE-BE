package com.hskgroup.profile.service;

import com.hskgroup.profile.converter.CertificationConverter;
import com.hskgroup.profile.converter.EducationConverter;
import com.hskgroup.profile.converter.ProfileConverter;
import com.hskgroup.profile.converter.ProjectConverter;
import com.hskgroup.profile.dto.*;
import com.hskgroup.profile.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IntegrationServiceImpl implements IntegrationService {

    private final ProfileSettingRepository profileSettingRepository;
    private final EducationRepository educationRepository;
    private final CertificationRepository certificationRepository;
    private final ProjectRepository projectRepository;
    private final TechStackRepository  techStackRepository;

    @Override // 통합 조회
    public IntegrationRes getIntegrationData() {
        // 프로필 정보 조회 (ProfileConverter)
        List<ProfileRes> getProfileInfo = profileSettingRepository.findAll().stream()
                .map(ProfileConverter::convertToProfileRes)
                .toList();
        // 학력 정보 조회 (EducationConverter)
        List<EducationRes> getEducationInfo = educationRepository.findAll().stream()
                .map(EducationConverter::convertToEducationRes).toList();
        // 자격증 정보 조회 (CertificationConverter)
        List<CertificationRes> getCertificationInfo = certificationRepository.findAll().stream()
                .map(CertificationConverter::convertToCertificationRes).toList();
        // 프로젝트 이력 조회 (ProjectConverter)
        List<ProjectRes> getProjectInfo = projectRepository.findAll().stream()
                .map(ProjectConverter::convertToProjectRes).toList();
        // 기술스택 정보 조회 (TechStackConverter)

        // 통합 조회 응답 회신
        return IntegrationRes.builder()
                .profileList(getProfileInfo)
                .educationList(getEducationInfo)
                .certificationList(getCertificationInfo)
                .projectList(getProjectInfo)
                .build();
    }
}
