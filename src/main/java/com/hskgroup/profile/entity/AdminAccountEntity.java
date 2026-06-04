package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin_account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminAccountEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 200)
    private String passwordHash;

    @Column(name = "refresh_token_id", length = 100)
    private String refreshTokenId;

    public static AdminAccountEntity create(String username, String passwordHash) {
        AdminAccountEntity adminAccountEntity = new AdminAccountEntity();
        adminAccountEntity.username = username;
        adminAccountEntity.passwordHash = passwordHash;
        return adminAccountEntity;
    }

    public void updatePassword(String passwordHash) {
        this.passwordHash = passwordHash;
        this.refreshTokenId = null;
    }

    public void updateRefreshTokenId(String refreshTokenId) {
        this.refreshTokenId = refreshTokenId;
    }
}
