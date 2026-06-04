package com.hskgroup.profile.repository;

import com.hskgroup.profile.entity.CertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<CertificationEntity, Long> {
    Optional<CertificationEntity> findByCertificationUuid(UUID certificationUuid);
}
