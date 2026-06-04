package com.hskgroup.profile.repository;

import com.hskgroup.profile.entity.AdminAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminAccountRepository extends JpaRepository<AdminAccountEntity, Long> {
    Optional<AdminAccountEntity> findByUserUuid(UUID userUUId);
}
