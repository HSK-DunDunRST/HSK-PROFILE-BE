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

    @Column(length = 255)
    private String github;

    @Column(length = 255)
    private String email;

    @Column(length = 100)
    private String discord;

    @Column(length = 255)
    private String instagram;

}






