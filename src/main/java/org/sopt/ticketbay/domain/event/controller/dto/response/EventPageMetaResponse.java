package org.sopt.ticketbay.domain.event.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.springframework.data.domain.Page;

@Schema(description = "베스트 인기티켓 목록 조회 시 페이지네이션 DTO")
public record EventPageMetaResponse(

    @Schema(description = "현재 페이지 값", example = "0")
    int page,

    @Schema(description = "현재 페이지 크기", example = "10")
    int size,

    @Schema(description = "전체 티켓 수", example = "20")
    long totalElements,

    @Schema(description = "전체 페이지 수. (totalPages - 1)까지 page 요청 가능", example = "2")
    int totalPages
) {

    public static EventPageMetaResponse from(Page<Event> pageData) {
        return new EventPageMetaResponse(
            pageData.getNumber(),
            pageData.getSize(),
            pageData.getTotalElements(),
            pageData.getTotalPages()
        );
    }
}
