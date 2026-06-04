package com.hskgroup.profile.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "security.admin")
public class AdminAccountProperties {
    private String username = "admin";
    private String password = "admin";
}
