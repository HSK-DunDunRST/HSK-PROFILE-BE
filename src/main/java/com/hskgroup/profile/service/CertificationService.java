package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.req.CertificationCreateReq;
import com.hskgroup.profile.dto.res.CertificationRes;
import com.hskgroup.profile.dto.req.CertificationUpdateReq;

import java.util.Optional;
import java.util.UUID;

public interface CertificationService {
    CertificationRes createCertification(CertificationCreateReq request);
    Optional<CertificationRes> updateCertification(UUID certificationUuid, CertificationUpdateReq request);
    boolean deleteCertification(UUID certificationUuid);
}
