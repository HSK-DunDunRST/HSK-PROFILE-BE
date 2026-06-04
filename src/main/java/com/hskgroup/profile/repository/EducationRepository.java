package com.hskgroup.profile.repository;

import com.hskgroup.profile.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EducationRepository extends JpaRepository<EducationEntity, Long> {
    Optional<EducationEntity> findByEducationId(UUID educationId);
}
