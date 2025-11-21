package org.sopt.ticketbay.domain.ticket.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum TicketErrorCode implements ErrorCode {

    // 404
    TICKET_NOT_FOUND(404, "TIC_404_001", "해당 티켓을 찾을 수 없습니다."),
    ;

    private final int status;
    private final String code;
    private final String message;

}
