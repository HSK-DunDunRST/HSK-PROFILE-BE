package com.hskgroup.profile.service;

import com.hskgroup.profile.converter.EducationConverter;
import com.hskgroup.profile.converter.ProfileConverter;
import com.hskgroup.profile.dto.EducationRes;
import com.hskgroup.profile.dto.IntegrationRes;
import com.hskgroup.profile.dto.ProfileRes;
import com.hskgroup.profile.repository.EducationRepository;
import com.hskgroup.profile.repository.ProfileSettingRepository;
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

    @Override // 통합 조회
    public IntegrationRes getIntegrationData() {
        // 프로필 정보 조회 (Converter 사용)
        List<ProfileRes> getProfileInfo = profileSettingRepository.findAll().stream()
                .map(ProfileConverter::convertToProfileRes).toList();
        // 학력 정보 조회 (Converter 사용)
        List<EducationRes> getEducationInfo = educationRepository.findAll().stream()
                .map(EducationConverter::convertToEducationRes).toList();
        //

        return IntegrationRes.builder()
                .profileList(getProfileInfo)
                .educationList(getEducationInfo)
                .build();
    }
}
