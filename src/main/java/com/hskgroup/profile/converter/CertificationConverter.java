package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.res.CertificationRes;
import com.hskgroup.profile.entity.CertificationEntity;

public class CertificationConverter {
    public static CertificationRes convertToCertificationRes(CertificationEntity certificationEntity) {
        return CertificationRes.builder()
                .certificationId(certificationEntity.getCertificationId())
                .certificationName(certificationEntity.getCertificationName())
                .organizationName(certificationEntity.getOrganizationName())
                .acquisitionDate(certificationEntity.getAcquisitionDate())
                .expirationDate(certificationEntity.getExpirationDate())
                .lastUpdateDate(certificationEntity.getUpdatedAt())
                .build();
    }
}
