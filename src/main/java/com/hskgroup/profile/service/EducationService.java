package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.EducationCreateReq;
import com.hskgroup.profile.dto.EducationRes;
import com.hskgroup.profile.dto.EducationUpdateReq;

import java.util.Optional;

public interface EducationService {
    EducationRes createEducation(EducationCreateReq request);
    Optional<EducationRes> updateEducation(Long educationId, EducationUpdateReq request);
    boolean deleteEducation(Long educationId);
}
