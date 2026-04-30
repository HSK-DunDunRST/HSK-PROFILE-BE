package com.hskgroup.profile.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EducationStatus {
    ENROLLED("재학"),
    MILITARY_LEAVE("군휴학"),
    GRADUATED("졸업");

    private final String description;
}
