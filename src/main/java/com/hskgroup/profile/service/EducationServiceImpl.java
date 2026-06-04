package com.hskgroup.profile.service;

import com.hskgroup.profile.converter.EducationConverter;
import com.hskgroup.profile.dto.req.EducationCreateReq;
import com.hskgroup.profile.dto.res.EducationRes;
import com.hskgroup.profile.dto.req.EducationUpdateReq;
import com.hskgroup.profile.entity.EducationEntity;
import com.hskgroup.profile.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;

    @Transactional
    @Override
    public EducationRes createEducation(EducationCreateReq request) {
        EducationEntity educationEntity = EducationEntity.create(
                request.getSchoolName(),
                request.getMajorName(),
                request.getEducationPeriod(),
                request.getEducationStatus()
        );
        return EducationConverter.convertToEducationRes(educationRepository.save(educationEntity));
    }

    @Transactional
    @Override
    public Optional<EducationRes> updateEducation(Long educationId, EducationUpdateReq request) {
        return educationRepository.findById(educationId)
                .map(educationEntity -> {
                    educationEntity.update(
                            request.getSchoolName(),
                            request.getMajorName(),
                            request.getEducationPeriod(),
                            request.getEducationStatus()
                    );
                    return EducationConverter.convertToEducationRes(educationEntity);
                });
    }

    @Transactional
    @Override
    public boolean deleteEducation(Long educationId) {
        return educationRepository.findById(educationId)
                .map(educationEntity -> {
                    educationRepository.delete(educationEntity);
                    return true;
                })
                .orElse(false);
    }
}
