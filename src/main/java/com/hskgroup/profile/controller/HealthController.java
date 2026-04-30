package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthController {

    @GetMapping("/check")
    public ApiResponse<?> getHealth(){
        return ApiResponse.onSuccess(HttpStatus.OK);
    }
}
