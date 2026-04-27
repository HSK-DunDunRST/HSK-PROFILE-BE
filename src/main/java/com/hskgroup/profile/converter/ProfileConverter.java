package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.ProfileRes;
import com.hskgroup.profile.dto.TechStackRes;
import com.hskgroup.profile.entity.ProfileEntity;
import com.hskgroup.profile.entity.TechStackEntity;

import java.util.List;

public class ProfileConverter {
    public static ProfileRes convertToProfileRes(ProfileEntity profileEntity,
                                                 List<TechStackEntity> techStackList) {
        List<TechStackRes> safeTechStackList = techStackList == null
                ? List.of()
                : techStackList.stream()
                        .map(TechStackConverter::convertToTechStackRes)
                        .toList();

        return ProfileRes.builder()
                .githubId(profileEntity.getGithubId())
                .emailAddress(profileEntity.getEmailAddress())
                .instagramId(profileEntity.getInstagramId())
                .techStackList(safeTechStackList)
                .lastUpdateDate(profileEntity.getUpdatedAt())
                .build();
    }
}
