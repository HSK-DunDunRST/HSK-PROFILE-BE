package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.dto.res.IntegrationRes;
import com.hskgroup.profile.service.IntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integration")
@RequiredArgsConstructor
public class IntegrationController {

    private final IntegrationService integrationService;

    @GetMapping("/info")
    public ApiResponse<IntegrationRes> getIntegrationInfo(){
        return ApiResponse.onSuccess(integrationService.getIntegrationData());
    }
}
