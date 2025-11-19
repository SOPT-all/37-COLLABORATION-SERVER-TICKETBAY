package org.sopt.ticketbay.domain.history.controller.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum HistorySuccessCode implements SuccessCode {

    ;

    private final int status;
    private final String code;
    private final String message;

}
