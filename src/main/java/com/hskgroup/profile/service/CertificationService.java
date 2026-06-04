package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.CertificationCreateReq;
import com.hskgroup.profile.dto.CertificationRes;
import com.hskgroup.profile.dto.CertificationUpdateReq;

import java.util.Optional;

public interface CertificationService {
    CertificationRes createCertification(CertificationCreateReq request);
    Optional<CertificationRes> updateCertification(Long certificationId, CertificationUpdateReq request);
    boolean deleteCertification(Long certificationId);
}
