package org.sopt.ticketbay.domain.user.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.ErrorCode;

@RequiredArgsConstructor
@Getter
public enum UserErrorCode implements ErrorCode {

    ;

    private final int status;
    private final String code;
    private final String message;

}
