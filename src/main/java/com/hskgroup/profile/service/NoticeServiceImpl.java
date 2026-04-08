package com.hskgroup.profile.service;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.apiPayload.exception.BaseException;
import com.hskgroup.profile.apiPayload.status.ErrorType;
import com.hskgroup.profile.converter.NoticeConverter;
import com.hskgroup.profile.dto.NoticeRes;
import com.hskgroup.profile.entity.NoticeEntity;
import com.hskgroup.profile.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeServiceImpl implements NoticeService {

    private NoticeRepository noticeRepository;

    @Override // 공지시항 전체 조회
    public List<NoticeRes> getAllNotices() {
        return noticeRepository.findAll().stream()
                .map(NoticeConverter::convertToNoticeRes)
                .toList();
    }

    @Override // 최신 공지사항 1개 조회
    public Optional<NoticeRes> getRecentNotice() {
        return noticeRepository.findTopByOrderByCreatedAtDesc()
                .map(NoticeConverter::convertToNoticeRes);
    }
}
