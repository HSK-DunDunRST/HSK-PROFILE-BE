package com.hskgroup.profile.service;

import com.hskgroup.profile.converter.CertificationConverter;
import com.hskgroup.profile.dto.CertificationCreateReq;
import com.hskgroup.profile.dto.CertificationRes;
import com.hskgroup.profile.dto.CertificationUpdateReq;
import com.hskgroup.profile.entity.CertificationEntity;
import com.hskgroup.profile.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Optional<CertificationRes> updateCertification(Long certificationId, CertificationUpdateReq request) {
        return certificationRepository.findById(certificationId)
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
    public boolean deleteCertification(Long certificationId) {
        return certificationRepository.findById(certificationId)
                .map(certificationEntity -> {
                    certificationRepository.delete(certificationEntity);
                    return true;
                })
                .orElse(false);
    }
}
