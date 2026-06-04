package com.hskgroup.profile.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/* 자격증 현황 조회 응답 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationRes {
    private UUID certificationId;
    private String certificationName;
    private String organizationName;
    private String acquisitionDate;
    private String expirationDate;
    private LocalDateTime lastUpdateDate;
}
