package com.hskgroup.profile.security;

import com.hskgroup.profile.entity.AdminAccountEntity;
import com.hskgroup.profile.repository.AdminAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AdminAccountInitializer implements ApplicationRunner {

    private final AdminAccountRepository adminAccountRepository;
    private final AdminAccountProperties adminAccountProperties;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
        if (adminAccountRepository.findByUsername(adminAccountProperties.getUsername()).isEmpty()) {
            adminAccountRepository.save(
                AdminAccountEntity.create(
                    adminAccountProperties.getUsername(),
                    passwordEncoder.encode(adminAccountProperties.getPassword())
                )
            );
        }
    }
}
