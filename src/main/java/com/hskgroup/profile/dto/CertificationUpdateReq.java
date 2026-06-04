package com.hskgroup.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationUpdateReq {
    private String certificationName;
    private String organizationName;
    private String acquisitionDate;
    private String expirationDate;
}
