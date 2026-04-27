package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "certification_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CertificationEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "certification_name", nullable = false, length = 100)
    private String certificationName;

    @Column(name = "organization_name", length = 100)
    private String organizationName;

    @Column(name = "acquisition_date", nullable = false, length = 20)
    private String acquisitionDate;

    @Column(name = "expiration_date", length = 20)
    private String expirationDate;
}
