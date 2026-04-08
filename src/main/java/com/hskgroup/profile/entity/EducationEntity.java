package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import com.hskgroup.profile.entity.enums.EducationStatus;
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

    @Column(name = "major_name", nullable = false, length = 100)
    private String majorName;

    @Column(name = "edu_period", nullable = false, length = 50)
    private String educationPeriod;

    @Enumerated(EnumType.STRING)
    @Column(name = "edu_status", nullable = false, length = 20)
    private EducationStatus educationStatus;
}
