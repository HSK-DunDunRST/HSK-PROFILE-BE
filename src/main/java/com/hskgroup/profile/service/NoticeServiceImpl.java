package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.NoticeRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeServiceImpl implements NoticeService {

    @Override // 공지시항 전체 조회
    public List<NoticeRes> getAllNotices() {
        return List.of();
    }

    @Override // 최신 공지사항 1개 조회
    public NoticeRes getRecentNotice() {
        return null;
    }
}
