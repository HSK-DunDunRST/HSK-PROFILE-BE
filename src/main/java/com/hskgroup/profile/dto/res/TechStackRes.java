package com.hskgroup.profile.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechStackRes {
    private String techStackName;
    private String techStackCreatedAt;
}
