package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.req.NoticeCreateReq;
import com.hskgroup.profile.dto.res.NoticeRes;
import com.hskgroup.profile.dto.req.NoticeUpdateReq;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoticeService {
    // 공지사항 전체 조회
    List<NoticeRes> getAllNotices();
    // 최신 공지시항 1개 조회
    Optional<NoticeRes> getRecentNotice();
    // UUID로 공지사항 조회
    Optional<NoticeRes> getNoticeByUuid(UUID noticeUuid);
    // 공지사항 등록
    NoticeRes createNotice(NoticeCreateReq request);
    // 공지사항 수정
    Optional<NoticeRes> updateNotice(UUID noticeUuid, NoticeUpdateReq request);
    // 공지사항 삭제
    boolean deleteNotice(UUID noticeUuid);
}
