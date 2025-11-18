package org.sopt.ticketbay.domain.seat.domain.exception;

import org.sopt.ticketbay.global.exception.BusinessException;

public class SeatException extends BusinessException {

    public SeatException(SeatErrorCode seatErrorCode) {
        super(seatErrorCode);
    }
}
