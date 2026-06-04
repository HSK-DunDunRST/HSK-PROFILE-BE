package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.res.TechStackRes;
import com.hskgroup.profile.entity.TechStackEntity;

public class TechStackConverter {
    public static TechStackRes convertToTechStackRes(TechStackEntity techStackEntity) {
        return TechStackRes.builder()
                .techStackName(techStackEntity.getTechName())
                .techStackCreatedAt(techStackEntity.getCreatedAt().toString())
                .build();
    }
}
