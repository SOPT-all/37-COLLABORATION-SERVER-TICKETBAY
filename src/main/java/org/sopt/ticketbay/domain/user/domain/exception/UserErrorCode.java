package org.sopt.ticketbay.domain.user.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    // 404 NOT FOUND
    USER_NOT_FOUND(404, "USE_404_001", "존재하지 않는 유저입니다."),
    ;

    private final int status;
    private final String code;
    private final String message;

}
