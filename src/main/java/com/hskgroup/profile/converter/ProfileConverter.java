package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.ProfileRes;
import com.hskgroup.profile.entity.ProfileEntity;
import com.hskgroup.profile.entity.TechStackEntity;

import java.util.List;

public class ProfileConverter {
    public static ProfileRes convertToProfileRes(ProfileEntity profileEntity,
                                                 List<TechStackEntity> techStackList) {
        List<TechStackEntity> safeTechStackList = techStackList == null
                ? List.of()
                : List.copyOf(techStackList);

        return ProfileRes.builder()
                .githubLink(profileEntity.getGithubLink())
                .emailAddress(profileEntity.getEmailAddress())
                .techStackList(safeTechStackList)
                .lastUpdateDate(profileEntity.getUpdatedAt())
                .build();
    }
}
