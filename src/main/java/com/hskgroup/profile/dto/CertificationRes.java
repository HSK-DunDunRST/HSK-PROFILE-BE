package com.hskgroup.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 자격증 현황 조회 응답 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationRes {
    private Long id;
    private String certificationName;
    private String organizationName;
    private String acquisitionDate;
    private String expirationDate;
}
