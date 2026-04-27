package com.hskgroup.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/* 공지사항 조회 응답 DTO */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeRes {
    private String noticeTitle;
    private String noticeContent;
    private LocalDateTime noticeCreateDate;
    private LocalDateTime noticeUpdateDate; // 필요시에만 사용, 불필요시 NULL처리
}
