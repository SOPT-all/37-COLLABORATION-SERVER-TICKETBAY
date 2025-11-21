package org.sopt.ticketbay.domain.history.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.sopt.ticketbay.domain.history.domain.History;

@Schema(description = "최근 본 티켓 DTO")
public record HistoryResponse(

    @Schema(description = "관련된 행사 ID (뷰에서는 최근 본 티켓이라고 되어있는데, 행사에 들어가야 실제 티켓이 나와서 행사 ID를 보내드립니다.)")
    Long eventId,

    @Schema(description = "관련 행사 이름")
    String name,

    @Schema(description = "행사 일시")
    LocalDateTime eventDate
) {

    public static HistoryResponse from(History history) {
        return new HistoryResponse(
            history.getEvent().getId(),
            history.getEvent().getName(),
            LocalDateTime.ofInstant(
                history.getEvent().getEventDate(),
                ZoneId.of("Asia/Seoul")
            )
        );
    }
}
