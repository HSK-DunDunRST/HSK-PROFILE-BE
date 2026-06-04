package com.hskgroup.profile.service;

import com.hskgroup.profile.converter.CertificationConverter;
import com.hskgroup.profile.dto.req.CertificationCreateReq;
import com.hskgroup.profile.dto.res.CertificationRes;
import com.hskgroup.profile.dto.req.CertificationUpdateReq;
import com.hskgroup.profile.entity.CertificationEntity;
import com.hskgroup.profile.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CertificationServiceImpl implements CertificationService {

    private final CertificationRepository certificationRepository;

    @Transactional
    @Override
    public CertificationRes createCertification(CertificationCreateReq request) {
        CertificationEntity certificationEntity = CertificationEntity.create(
                request.getCertificationName(),
                request.getOrganizationName(),
                request.getAcquisitionDate(),
                request.getExpirationDate()
        );
        return CertificationConverter.convertToCertificationRes(certificationRepository.save(certificationEntity));
    }

    @Transactional
    @Override
    public Optional<CertificationRes> updateCertification(UUID certificationUuid, CertificationUpdateReq request) {
        return certificationRepository.findByCertificationId(certificationUuid)
                .map(certificationEntity -> {
                    certificationEntity.update(
                            request.getCertificationName(),
                            request.getOrganizationName(),
                            request.getAcquisitionDate(),
                            request.getExpirationDate()
                    );
                    return CertificationConverter.convertToCertificationRes(certificationEntity);
                });
    }

    @Transactional
    @Override
    public boolean deleteCertification(UUID certificationUuid) {
        return certificationRepository.findByCertificationId(certificationUuid)
                .map(certificationEntity -> {
                    certificationRepository.delete(certificationEntity);
                    return true;
                })
                .orElse(false);
    }
}
