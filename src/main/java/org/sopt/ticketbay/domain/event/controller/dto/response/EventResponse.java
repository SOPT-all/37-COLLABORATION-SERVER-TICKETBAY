package org.sopt.ticketbay.domain.event.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import org.sopt.ticketbay.domain.event.service.dto.response.EventResult;

@Schema(description = "해당 티켓(행사) DTO")
public record EventResponse(

    @Schema(description = "행사 ID", example = "1")
    Long id,

    @Schema(description = "행사명", example = "한국시리즈 5차전 [대전]")
    String name,

    @Schema(description = "행사 장소", example = "한화생명볼파크")
    String place,

    @Schema(description = "1위 ~ 5위 여부", example = "true")
    boolean isTopRankng
) {

    public static EventResponse from(EventResult event) {
        return new EventResponse(
            event.id(),
            event.name(),
            event.place(),
            event.isTopRanking()
        );
    }
}
