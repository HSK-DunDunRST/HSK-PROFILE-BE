package com.hskgroup.profile.dto;

import com.hskgroup.profile.entity.enums.EducationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationUpdateReq {
    private String schoolName;
    private String majorName;
    private String educationPeriod;
    private EducationStatus educationStatus;
}
