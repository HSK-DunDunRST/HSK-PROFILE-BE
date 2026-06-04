package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.dto.AdminPasswordChangeReq;
import com.hskgroup.profile.dto.AuthLoginReq;
import com.hskgroup.profile.dto.AuthRefreshReq;
import com.hskgroup.profile.dto.AuthTokenRes;
import com.hskgroup.profile.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<AuthTokenRes> login(@Valid @RequestBody AuthLoginReq request) {
        return ApiResponse.onSuccess(authService.login(request));
    }

    @PostMapping("/refresh")
    public ApiResponse<AuthTokenRes> refresh(@Valid @RequestBody AuthRefreshReq request) {
        return ApiResponse.onSuccess(authService.refresh(request));
    }

    @PutMapping("/password")
    public ApiResponse<Void> changePassword(@Valid @RequestBody AdminPasswordChangeReq request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authService.changePassword(authentication.getName(), request);
        return ApiResponse.onSuccess(null);
    }
}
