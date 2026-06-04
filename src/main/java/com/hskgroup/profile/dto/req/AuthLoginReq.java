package com.hskgroup.profile.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginReq {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
