package com.hskgroup.profile.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final String TOKEN_TYPE = "typ";
    private static final String TOKEN_TYPE_ACCESS = "access";
    private static final String TOKEN_TYPE_REFRESH = "refresh";

    private final JwtProperties jwtProperties;
    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        byte[] keyBytes = jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8);
        if (keyBytes.length < 32) {
            throw new IllegalStateException("JWT secret must be at least 32 bytes");
        }
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createAccessToken(String username) {
        Instant now = Instant.now();
        Instant expiresAt = now.plus(jwtProperties.getAccessTokenExpiration());
        return Jwts.builder()
                .subject(username)
                .issuer(jwtProperties.getIssuer())
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiresAt))
                .claim(TOKEN_TYPE, TOKEN_TYPE_ACCESS)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String createRefreshToken(String username, String refreshTokenId) {
        Instant now = Instant.now();
        Instant expiresAt = now.plus(jwtProperties.getRefreshTokenExpiration());
        return Jwts.builder()
                .subject(username)
                .issuer(jwtProperties.getIssuer())
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiresAt))
                .id(refreshTokenId)
                .claim(TOKEN_TYPE, TOKEN_TYPE_REFRESH)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isAccessToken(String token) {
        return TOKEN_TYPE_ACCESS.equals(getClaim(token, TOKEN_TYPE));
    }

    public boolean isRefreshToken(String token) {
        return TOKEN_TYPE_REFRESH.equals(getClaim(token, TOKEN_TYPE));
    }

    public String getUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    public String getTokenId(String token) {
        return parseToken(token).getPayload().getId();
    }

    public String generateRefreshTokenId() {
        return UUID.randomUUID().toString();
    }

    public long getAccessTokenExpiresInSeconds() {
        return jwtProperties.getAccessTokenExpiration().getSeconds();
    }

    public long getRefreshTokenExpiresInSeconds() {
        return jwtProperties.getRefreshTokenExpiration().getSeconds();
    }

    private String getClaim(String token, String name) {
        Claims claims = parseToken(token).getPayload();
        Object value = claims.get(name);
        return value == null ? null : value.toString();
    }

    private Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token);
    }
}
