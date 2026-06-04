package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.AdminPasswordChangeReq;
import com.hskgroup.profile.dto.AuthLoginReq;
import com.hskgroup.profile.dto.AuthRefreshReq;
import com.hskgroup.profile.dto.AuthTokenRes;

public interface AuthService {
    AuthTokenRes login(AuthLoginReq request);
    AuthTokenRes refresh(AuthRefreshReq request);
    void changePassword(String username, AdminPasswordChangeReq request);
}
