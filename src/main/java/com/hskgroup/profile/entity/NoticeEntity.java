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
    @Column(name = "notice_uuid", nullable = false, unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID noticeUuid;

    @Column(name = "notice_title", nullable = false)
    private String noticeTitle;

    @Lob
    @Column(name = "notice_content", nullable = false)
    private String noticeContent;

}
