package org.sopt.ticketbay.domain.event.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "베스트 인기티켓 목록 DTO")
public record EventListResponse(

    @Schema(description = "베스트 인기티켓 목록")
    List<EventResponse> events
) {

    public static EventListResponse from(List<EventResponse> events) {
        return new EventListResponse(events);
    }
}
