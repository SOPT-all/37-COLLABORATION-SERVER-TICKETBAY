package org.sopt.ticketbay.domain.event.domain.exception;

import org.sopt.ticketbay.global.exception.BusinessException;

public class EventException extends BusinessException {

    public EventException(EventErrorCode eventErrorCode) {
        super(eventErrorCode);
    }
}
