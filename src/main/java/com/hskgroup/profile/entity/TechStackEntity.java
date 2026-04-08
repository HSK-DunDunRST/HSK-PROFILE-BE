package com.hskgroup.profile.entity;

import com.hskgroup.profile.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "techstack_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TechStackEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tech_name", nullable = false, length = 100)
    private String techName;
}
