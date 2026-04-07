package com.hskgroup.profile.repository;

import com.hskgroup.profile.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileSettingRepository extends JpaRepository<ProfileEntity, Long> {

    Optional<ProfileEntity> findTopByOrderByIdDesc();
}
