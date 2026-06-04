package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.req.EducationCreateReq;
import com.hskgroup.profile.dto.res.EducationRes;
import com.hskgroup.profile.dto.req.EducationUpdateReq;

import java.util.Optional;

public interface EducationService {
    EducationRes createEducation(EducationCreateReq request);
    Optional<EducationRes> updateEducation(Long educationId, EducationUpdateReq request);
    boolean deleteEducation(Long educationId);
}
