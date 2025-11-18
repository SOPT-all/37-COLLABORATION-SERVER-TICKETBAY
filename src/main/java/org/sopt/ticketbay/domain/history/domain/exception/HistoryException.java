package org.sopt.ticketbay.domain.history.domain.exception;

import org.sopt.ticketbay.global.exception.BusinessException;

public class HistoryException extends BusinessException {

    public HistoryException(HistoryErrorCode historyErrorCode) {
        super(historyErrorCode);
    }
}
