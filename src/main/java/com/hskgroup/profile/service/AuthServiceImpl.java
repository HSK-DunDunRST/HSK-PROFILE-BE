package com.hskgroup.profile.service;

import com.hskgroup.profile.apiPayload.exception.BaseException;
import com.hskgroup.profile.apiPayload.status.ErrorType;
import com.hskgroup.profile.dto.req.AdminPasswordChangeReq;
import com.hskgroup.profile.dto.req.AuthLoginReq;
import com.hskgroup.profile.dto.req.AuthRefreshReq;
import com.hskgroup.profile.dto.res.AuthTokenRes;
import com.hskgroup.profile.entity.AdminAccountEntity;
import com.hskgroup.profile.repository.AdminAccountRepository;
import com.hskgroup.profile.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final AdminAccountRepository adminAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public AuthTokenRes login(AuthLoginReq request) {
        AdminAccountEntity adminAccount = adminAccountRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BaseException(ErrorType._UNAUTHORIZED));

        if (!passwordEncoder.matches(request.getPassword(), adminAccount.getPasswordHash())) {
            throw new BaseException(ErrorType._UNAUTHORIZED);
        }

        String refreshTokenId = jwtTokenProvider.generateRefreshTokenId();
        adminAccount.updateRefreshTokenId(refreshTokenId);

        return buildTokenResponse(adminAccount.getUsername(), refreshTokenId);
    }

    @Transactional
    @Override
    public AuthTokenRes refresh(AuthRefreshReq request) {
        String refreshToken = request.getRefreshToken();
        if (!jwtTokenProvider.isTokenValid(refreshToken) || !jwtTokenProvider.isRefreshToken(refreshToken)) {
            throw new BaseException(ErrorType._UNAUTHORIZED);
        }

        String username = jwtTokenProvider.getUsername(refreshToken);
        String tokenId = jwtTokenProvider.getTokenId(refreshToken);

        AdminAccountEntity adminAccount = adminAccountRepository.findByUsername(username)
                .orElseThrow(() -> new BaseException(ErrorType._UNAUTHORIZED));

        if (adminAccount.getRefreshTokenId() == null || !adminAccount.getRefreshTokenId().equals(tokenId)) {
            throw new BaseException(ErrorType._UNAUTHORIZED);
        }

        String newRefreshTokenId = jwtTokenProvider.generateRefreshTokenId();
        adminAccount.updateRefreshTokenId(newRefreshTokenId);

        return buildTokenResponse(username, newRefreshTokenId);
    }

    @Transactional
    @Override
    public void changePassword(String username, AdminPasswordChangeReq request) {
        AdminAccountEntity adminAccount = adminAccountRepository.findByUsername(username)
                .orElseThrow(() -> new BaseException(ErrorType._UNAUTHORIZED));

        if (!passwordEncoder.matches(request.getCurrentPassword(), adminAccount.getPasswordHash())) {
            throw new BaseException(ErrorType._UNAUTHORIZED);
        }

        adminAccount.updatePassword(passwordEncoder.encode(request.getNewPassword()));
    }

    private AuthTokenRes buildTokenResponse(String username, String refreshTokenId) {
        String accessToken = jwtTokenProvider.createAccessToken(username);
        String refreshToken = jwtTokenProvider.createRefreshToken(username, refreshTokenId);

        return AuthTokenRes.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiresIn(jwtTokenProvider.getAccessTokenExpiresInSeconds())
                .refreshTokenExpiresIn(jwtTokenProvider.getRefreshTokenExpiresInSeconds())
                .build();
    }

    @Transactional
    public void logout(String username) {
        AdminAccountEntity adminAccount = adminAccountRepository.findByUsername(username)
                .orElseThrow(() -> new BaseException(ErrorType._USER_NOT_FOUND));
        adminAccount.updateRefreshTokenId(null);
    }
}
