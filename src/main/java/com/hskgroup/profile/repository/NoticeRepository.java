package com.hskgroup.profile.repository;

import com.hskgroup.profile.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    // 최신 공지사항 조회
    Optional<NoticeEntity> findTopByOrderByCreatedAtDesc();
}
