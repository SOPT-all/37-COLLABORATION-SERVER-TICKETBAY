package org.sopt.ticketbay.domain.history.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum HistoryErrorCode implements ErrorCode {

    ;

    private final int status;
    private final String code;
    private final String message;

}
