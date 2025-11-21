package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import org.sopt.ticketbay.domain.ticket.service.dto.response.EventInfo;

@Schema(description = "티켓 상세 조회 시 해당 티켓의 행사 정보 DTO")
public record EventResponse(

    @Schema(description = "행사 ID", example = "1")
    Long id,

    @Schema(description = "행사 대분류", example = "스포츠")
    String mainCategory,

    @Schema(description = "행사 소분류", example = "2025 프로야구 포스트 시즌")
    String subCategory,

    @Schema(description = "행사 이름", example = "한국시리즈 5차전 [대전]")
    String name,

    @Schema(description = "행사 일시", example = "2025-10-31T18:30:00")
    LocalDateTime date,

    @Schema(description = "행사 장소", example = "한화 생명 볼파크")
    String place,

    @Schema(description = "행사 상세명", example = "LG vs 한화")
    String detailName
) {

    public static EventResponse from(EventInfo eventInfo) {
        return new EventResponse(
            eventInfo.id(),
            eventInfo.mainCategory(),
            eventInfo.subCategory(),
            eventInfo.name(),
            eventInfo.date(),
            eventInfo.place(),
            eventInfo.detailName()
        );
    }
}
