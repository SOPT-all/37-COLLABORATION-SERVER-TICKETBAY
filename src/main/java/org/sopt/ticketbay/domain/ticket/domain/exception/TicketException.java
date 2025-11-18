package org.sopt.ticketbay.domain.ticket.domain.exception;

import org.sopt.ticketbay.global.exception.BusinessException;

public class TicketException extends BusinessException {

    public TicketException(TicketErrorCode ticketErrorCode) {
        super(ticketErrorCode);
    }
}
