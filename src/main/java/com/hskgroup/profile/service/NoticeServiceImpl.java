package com.hskgroup.profile.service;

import com.hskgroup.profile.converter.NoticeConverter;
import com.hskgroup.profile.dto.NoticeCreateReq;
import com.hskgroup.profile.dto.NoticeRes;
import com.hskgroup.profile.dto.NoticeUpdateReq;
import com.hskgroup.profile.entity.NoticeEntity;
import com.hskgroup.profile.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override // 공지시항 전체 조회
    public List<NoticeRes> getAllNotices() {
        return noticeRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(NoticeConverter::convertToNoticeRes)
                .toList();
    }

    @Override // 최신 공지사항 1개 조회
    public Optional<NoticeRes> getRecentNotice() {
        return noticeRepository.findTopByOrderByCreatedAtDesc()
                .map(NoticeConverter::convertToNoticeRes);
    }

    @Override // UUID로 공지사항 조회
    public Optional<NoticeRes> getNoticeByUuid(UUID noticeUuid) {
        return noticeRepository.findByNoticeUuid(noticeUuid)
                .map(NoticeConverter::convertToNoticeRes);
    }

    @Transactional
    @Override // 공지사항 등록
    public NoticeRes createNotice(NoticeCreateReq request) {
        NoticeEntity noticeEntity = NoticeEntity.create(request.getNoticeTitle(), request.getNoticeContent());
        return NoticeConverter.convertToNoticeRes(noticeRepository.save(noticeEntity));
    }

    @Transactional
    @Override // 공지사항 수정
    public Optional<NoticeRes> updateNotice(UUID noticeUuid, NoticeUpdateReq request) {
        return noticeRepository.findByNoticeUuid(noticeUuid)
                .map(noticeEntity -> {
                    noticeEntity.update(request.getNoticeTitle(), request.getNoticeContent());
                    return NoticeConverter.convertToNoticeRes(noticeEntity);
                });
    }

    @Transactional
    @Override // 공지사항 삭제
    public boolean deleteNotice(UUID noticeUuid) {
        return noticeRepository.findByNoticeUuid(noticeUuid)
                .map(noticeEntity -> {
                    noticeRepository.delete(noticeEntity);
                    return true;
                })
                .orElse(false);
    }
}
