package com.hskgroup.profile.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@Getter
@Setter
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {
    private String secret;
    private String issuer;
    private long accessTokenExpirationMinutes = 15;
    private long refreshTokenExpirationDays = 7;

    public Duration getAccessTokenExpiration() {
        return Duration.ofMinutes(accessTokenExpirationMinutes);
    }

    public Duration getRefreshTokenExpiration() {
        return Duration.ofDays(refreshTokenExpirationDays);
    }
}
