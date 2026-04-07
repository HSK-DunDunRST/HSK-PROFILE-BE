package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "education_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EducationEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "school_name", nullable = false, length = 100)
    private String schoolName;

    @Column(length = 100)
    private String major;

    @Column(length = 50)
    private String period;

    @Column(length = 20)
    private String status;
}
