package com.hskgroup.profile.dto;

import com.hskgroup.profile.entity.TechStackEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/* 프로필 정보 조회 응답 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileRes {
    private Long id;
    private String githubLink;
    private String emailAddress;
    private List<TechStackEntity> techStackList;
}
