package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.req.AdminPasswordChangeReq;
import com.hskgroup.profile.dto.req.AuthLoginReq;
import com.hskgroup.profile.dto.req.AuthRefreshReq;
import com.hskgroup.profile.dto.res.AuthTokenRes;

public interface AuthService {
    AuthTokenRes login(AuthLoginReq request);
    AuthTokenRes refresh(AuthRefreshReq request);
    void changePassword(String username, AdminPasswordChangeReq request);
    void logout(String username);
}
