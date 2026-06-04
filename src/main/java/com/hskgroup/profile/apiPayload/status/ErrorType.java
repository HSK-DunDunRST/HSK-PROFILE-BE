package com.hskgroup.profile.apiPayload.status;

import com.hskgroup.profile.apiPayload.code.BaseErrorCode;
import com.hskgroup.profile.apiPayload.dto.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType implements BaseErrorCode {
    // 에러 예시
    _FAIL_REASON(HttpStatus.BAD_REQUEST, "FAIL", "기본 요청에 실패했어요."),

    // 일반적인 응답
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청이에요!"),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요해요!"),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "허용되지 않은 요청이에요!"),
    _RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "RESOURCE404", "리소스를 찾을 수 없어요!"),
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버에 에러가 있어요!"),
    _MISSING_FILED_ERROR(HttpStatus.NOT_IMPLEMENTED, "FIELD501", "필수 파라미터가 누락되었어요!"),
    _USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER404", "사용자를 찾을 수 없어요!");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
