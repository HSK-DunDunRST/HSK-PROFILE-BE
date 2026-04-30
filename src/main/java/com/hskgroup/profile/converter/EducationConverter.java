package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.EducationRes;
import com.hskgroup.profile.entity.EducationEntity;

public class EducationConverter {
    public static EducationRes convertToEducationRes(EducationEntity educationEntity) {
        return EducationRes.builder()
                .schoolName(educationEntity.getSchoolName())
                .majorName(educationEntity.getMajorName())
                .educationPeriod(educationEntity.getEducationPeriod())
                .educationStatus(educationEntity.getEducationStatus().getDescription())
                .build();
    }
}
