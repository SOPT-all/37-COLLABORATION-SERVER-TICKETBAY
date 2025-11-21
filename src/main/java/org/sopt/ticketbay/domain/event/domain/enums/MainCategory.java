package org.sopt.ticketbay.domain.event.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MainCategory {
    
    CONCERT("콘서트"),
    SPORTS("스포츠"),
    MUSICAL_PLAY("뮤지컬/연극"),
    MOVIE_EXHIBITION("영화/전시"),
    TRIP("숙박/여행"),
    COUPON("상품권/쿠폰"),
    ON_SALES("정가이하")
    ;
    
    private final String name;

}
