package com.hskgroup.profile.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/* 프로필 정보 조회 응답 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileRes {
    private String githubId;
    private String emailAddress;
    private String instagramId;
    private List<TechStackRes> techStackList;
    private LocalDateTime lastUpdateDate;
}
