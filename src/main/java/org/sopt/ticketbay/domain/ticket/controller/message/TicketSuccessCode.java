package org.sopt.ticketbay.domain.ticket.controller.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum TicketSuccessCode implements SuccessCode {

    TICKET_LIST_RETRIEVED_SUCCESS(200, "TIC_200_001", "성공적으로 티켓 목록을 조회했습니다."),
    ;

    private final int status;
    private final String code;
    private final String message;

}
