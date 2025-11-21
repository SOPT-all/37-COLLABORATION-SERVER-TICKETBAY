package org.sopt.ticketbay.domain.event.controller.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.global.response.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum EventSuccessCode implements SuccessCode {
    EVENT_TOP_LIST_RETRIEVED_SUCCESS(200, "EVN_200_001", "성공적으로 인기 이벤트 랭킹 목록을 조회했습니다.")

    ;

    private final int status;
    private final String code;
    private final String message;

}
