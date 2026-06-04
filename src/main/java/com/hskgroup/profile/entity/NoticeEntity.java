package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "notice_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    @Column(name = "notice_id", nullable = false, unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID noticeId;

    @Column(name = "notice_title", nullable = false)
    private String noticeTitle;

    @Lob
    @Column(name = "notice_content", nullable = false)
    private String noticeContent;

    public static NoticeEntity create(String noticeTitle, String noticeContent) {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.noticeTitle = noticeTitle;
        noticeEntity.noticeContent = noticeContent;
        return noticeEntity;
    }

    public void update(String noticeTitle, String noticeContent) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }

}
