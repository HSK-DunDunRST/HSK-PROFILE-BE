package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.ProfileRes;
import com.hskgroup.profile.entity.ProfileEntity;

public class ProfileConverter {
    public static ProfileRes convertToProfileRes(ProfileEntity profileEntity) {
        return ProfileRes.builder()
                .id(profileEntity.getId())
                .githubLink(profileEntity.getGithubLink())
                .emailAddress(profileEntity.getEmailAddress())
                .lastUpdateDate(profileEntity.getUpdatedAt())
                .build();
    }
}
