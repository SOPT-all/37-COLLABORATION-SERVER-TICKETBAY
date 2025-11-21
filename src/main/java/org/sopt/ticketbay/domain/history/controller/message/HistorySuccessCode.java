package org.sopt.ticketbay.domain.history.controller.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum HistorySuccessCode implements SuccessCode {

    // 200 OK
    HISTORY_LIST_RETRIEVED_SUCCESS(200, "HIS_200_001", "성공적으로 최근 조회 목록을 조회했습니다.")

    ;

    private final int status;
    private final String code;
    private final String message;

}
