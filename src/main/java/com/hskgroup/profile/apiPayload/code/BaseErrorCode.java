package com.hskgroup.profile.apiPayload.code;

import com.hskgroup.profile.apiPayload.dto.ErrorReasonDTO;

public interface BaseErrorCode {
    public ErrorReasonDTO getReason();
    public ErrorReasonDTO getReasonHttpStatus();
}
