package org.sopt.ticketbay.domain.event.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum EventErrorCode implements ErrorCode {

    ;

    private final int status;
    private final String code;
    private final String message;

}
