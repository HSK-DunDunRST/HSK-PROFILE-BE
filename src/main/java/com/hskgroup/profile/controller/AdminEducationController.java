package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.apiPayload.status.SuccessStatus;
import com.hskgroup.profile.dto.req.EducationCreateReq;
import com.hskgroup.profile.dto.res.EducationRes;
import com.hskgroup.profile.dto.req.EducationUpdateReq;
import com.hskgroup.profile.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/adm/education")
@RequiredArgsConstructor
public class AdminEducationController {

    private final EducationService educationService;

    @PostMapping
    public ApiResponse<EducationRes> createEducation(@RequestBody EducationCreateReq educationCreateReq) {
        return ApiResponse.onSuccess(educationService.createEducation(educationCreateReq));
    }

    @PutMapping("/{educationId}")
    public ApiResponse<EducationRes> updateEducation(@PathVariable UUID educationId, @RequestBody EducationUpdateReq educationCreateReq) {
        return educationService.updateEducation(educationId, educationCreateReq)
                .map(education -> ApiResponse.of(SuccessStatus._OK, education))
                .orElse(ApiResponse.of(SuccessStatus._NO_CONTENT, null));
    }

    @DeleteMapping("/{educationId}")
    public ApiResponse<Void> deleteEducation(@PathVariable UUID educationId) {
        boolean deleted = educationService.deleteEducation(educationId);
        return deleted
                ? ApiResponse.of(SuccessStatus._OK, null)
                : ApiResponse.of(SuccessStatus._NO_CONTENT, null);
    }
}
