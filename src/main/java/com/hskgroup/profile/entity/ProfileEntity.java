package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profile_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "github_id", nullable = false)
    private String githubId;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "instagram_id", nullable = false)
    private String instagramId;

}






