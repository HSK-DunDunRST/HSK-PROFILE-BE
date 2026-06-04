package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import com.hskgroup.profile.entity.enums.EducationStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "education_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EducationEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    @Column(name = "education_id", nullable = false, unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID educationId;

    @Column(name = "school_name", nullable = false, length = 100)
    private String schoolName;

    @Column(name = "major_name", nullable = false, length = 100)
    private String majorName;

    @Column(name = "edu_period", nullable = false, length = 50)
    private String educationPeriod;

    @Enumerated(EnumType.STRING)
    @Column(name = "edu_status", nullable = false, length = 20)
    private EducationStatus educationStatus;

    public static EducationEntity create(String schoolName, String majorName, String educationPeriod, EducationStatus educationStatus) {
        EducationEntity educationEntity = new EducationEntity();
        educationEntity.schoolName = schoolName;
        educationEntity.majorName = majorName;
        educationEntity.educationPeriod = educationPeriod;
        educationEntity.educationStatus = educationStatus;
        return educationEntity;
    }

    public void update(String schoolName, String majorName, String educationPeriod, EducationStatus educationStatus) {
        this.schoolName = schoolName;
        this.majorName = majorName;
        this.educationPeriod = educationPeriod;
        this.educationStatus = educationStatus;
    }
}
