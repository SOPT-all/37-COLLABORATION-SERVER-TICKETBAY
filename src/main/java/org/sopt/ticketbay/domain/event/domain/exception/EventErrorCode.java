package org.sopt.ticketbay.domain.event.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum EventErrorCode implements ErrorCode {

    // 404 NOT FOUND
    EVENT_NOT_FOUND(404, "EVN_404_001", "존재하지 않는 이벤트입니다."),
    ;

    private final int status;
    private final String code;
    private final String message;

}
