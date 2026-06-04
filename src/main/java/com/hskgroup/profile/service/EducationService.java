package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.req.EducationCreateReq;
import com.hskgroup.profile.dto.res.EducationRes;
import com.hskgroup.profile.dto.req.EducationUpdateReq;

import java.util.Optional;
import java.util.UUID;

public interface EducationService {
    EducationRes createEducation(EducationCreateReq request);
    Optional<EducationRes> updateEducation(UUID educationId, EducationUpdateReq request);
    boolean deleteEducation(UUID educationId);
}
