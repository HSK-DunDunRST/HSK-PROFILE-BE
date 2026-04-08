package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.NoticeRes;

import java.util.List;

public interface NoticeService {
    // 공지사항 전체 조회
    List<NoticeRes> getAllNotices();
    // 최신 공지시항 1개 조회
    NoticeRes getRecentNotice();
}
