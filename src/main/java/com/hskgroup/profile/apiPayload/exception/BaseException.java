package com.hskgroup.profile.apiPayload.exception;

import com.hskgroup.profile.apiPayload.code.BaseErrorCode;
import com.hskgroup.profile.apiPayload.dto.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@AllArgsConstructor
@Log4j2
public class BaseException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }

}
