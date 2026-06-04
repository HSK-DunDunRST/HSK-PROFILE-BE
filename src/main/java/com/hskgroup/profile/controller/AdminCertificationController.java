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

import java.util.UUID;

@RestController
@RequestMapping("/adm/certification")
@RequiredArgsConstructor
public class AdminCertificationController {

    private final CertificationService certificationService;

    @PostMapping
    public ApiResponse<CertificationRes> createCertification(@RequestBody CertificationCreateReq certificationCreateReq) {
        return ApiResponse.onSuccess(certificationService.createCertification(certificationCreateReq));
    }

    @PutMapping("/{certificationUuid}")
    public ApiResponse<CertificationRes> updateCertification(@PathVariable UUID certificationUuid, @RequestBody CertificationUpdateReq certificationCreateReq) {
        return certificationService.updateCertification(certificationUuid, certificationCreateReq)
                .map(certification -> ApiResponse.of(SuccessStatus._OK, certification))
                .orElse(ApiResponse.of(SuccessStatus._NO_CONTENT, null));
    }

    @DeleteMapping("/{certificationUuid}")
    public ApiResponse<Void> deleteCertification(@PathVariable UUID certificationUuid) {
        boolean deleted = certificationService.deleteCertification(certificationUuid);
        return deleted
                ? ApiResponse.of(SuccessStatus._OK, null)
                : ApiResponse.of(SuccessStatus._NO_CONTENT, null);
    }
}
