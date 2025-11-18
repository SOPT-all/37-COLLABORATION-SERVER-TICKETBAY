package org.sopt.ticketbay.domain.user.domain.exception;

import org.sopt.ticketbay.global.exception.BusinessException;

public class UserException extends BusinessException {

    public UserException(UserErrorCode userErrorCode) {
        super(userErrorCode);
    }
}
