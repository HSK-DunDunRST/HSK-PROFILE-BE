package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.apiPayload.status.SuccessStatus;
import com.hskgroup.profile.dto.CertificationCreateReq;
import com.hskgroup.profile.dto.CertificationRes;
import com.hskgroup.profile.dto.CertificationUpdateReq;
import com.hskgroup.profile.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/certification")
@RequiredArgsConstructor
public class AdminCertificationController {

    private final CertificationService certificationService;

    @PostMapping
    public ApiResponse<CertificationRes> createCertification(@RequestBody CertificationCreateReq request) {
        return ApiResponse.onSuccess(certificationService.createCertification(request));
    }

    @PutMapping("/{certificationId}")
    public ApiResponse<CertificationRes> updateCertification(@PathVariable Long certificationId, @RequestBody CertificationUpdateReq request) {
        return certificationService.updateCertification(certificationId, request)
                .map(certification -> ApiResponse.of(SuccessStatus._OK, certification))
                .orElse(ApiResponse.of(SuccessStatus._NO_CONTENT, null));
    }

    @DeleteMapping("/{certificationId}")
    public ApiResponse<Void> deleteCertification(@PathVariable Long certificationId) {
        boolean deleted = certificationService.deleteCertification(certificationId);
        return deleted
                ? ApiResponse.of(SuccessStatus._OK, null)
                : ApiResponse.of(SuccessStatus._NO_CONTENT, null);
    }
}
