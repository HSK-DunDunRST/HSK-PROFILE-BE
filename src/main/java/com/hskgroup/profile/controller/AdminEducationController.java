package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.apiPayload.status.SuccessStatus;
import com.hskgroup.profile.dto.EducationCreateReq;
import com.hskgroup.profile.dto.EducationRes;
import com.hskgroup.profile.dto.EducationUpdateReq;
import com.hskgroup.profile.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/education")
@RequiredArgsConstructor
public class AdminEducationController {

    private final EducationService educationService;

    @PostMapping
    public ApiResponse<EducationRes> createEducation(@RequestBody EducationCreateReq request) {
        return ApiResponse.onSuccess(educationService.createEducation(request));
    }

    @PutMapping("/{educationId}")
    public ApiResponse<EducationRes> updateEducation(@PathVariable Long educationId, @RequestBody EducationUpdateReq request) {
        return educationService.updateEducation(educationId, request)
                .map(education -> ApiResponse.of(SuccessStatus._OK, education))
                .orElse(ApiResponse.of(SuccessStatus._NO_CONTENT, null));
    }

    @DeleteMapping("/{educationId}")
    public ApiResponse<Void> deleteEducation(@PathVariable Long educationId) {
        boolean deleted = educationService.deleteEducation(educationId);
        return deleted
                ? ApiResponse.of(SuccessStatus._OK, null)
                : ApiResponse.of(SuccessStatus._NO_CONTENT, null);
    }
}
