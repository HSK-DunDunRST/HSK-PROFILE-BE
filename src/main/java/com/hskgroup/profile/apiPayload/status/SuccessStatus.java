package com.hskgroup.profile.apiPayload.status;

import com.hskgroup.profile.apiPayload.code.BaseCode;
import com.hskgroup.profile.apiPayload.dto.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "200 OK", "조회에 성공했어요!"),
    _NO_CONTENT(HttpStatus.NO_CONTENT, "204 NO_CONTENT", "조회할 데이터가 없어요!"),;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}