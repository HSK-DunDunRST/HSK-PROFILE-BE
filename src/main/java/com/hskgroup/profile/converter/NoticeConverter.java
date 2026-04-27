package com.hskgroup.profile.converter;

import com.hskgroup.profile.dto.NoticeRes;
import com.hskgroup.profile.entity.NoticeEntity;

public class NoticeConverter {
    public static NoticeRes convertToNoticeRes(NoticeEntity noticeEntity) {
        return NoticeRes.builder()
                .noticeTitle(noticeEntity.getNoticeTitle())
                .noticeContent(noticeEntity.getNoticeContent())
                .noticeCreateDate(noticeEntity.getCreatedAt())
                .build();
    }
}
