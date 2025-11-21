package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketResult;

@Schema(description = "티켓 목록 내부 정보 DTO")
public record TicketResponse(

    @Schema(description = "티켓 ID", example = "1")
    Long id,

    @Schema(description = "티켓 일시", example = "2025-10-31T18:30:00")
    LocalDateTime date,

    @Schema(description = "티켓 세부 이름", example = "LG vs 한화")
    String detailName,

    @Schema(description = "티켓 구역", example = "507")
    int area,

    @Schema(description = "티켓 좌석 열번호", example = "2")
    int seatColumn,

    @Schema(description = "티켓 좌석 종류", example = "외야지정석")
    String seatType,

    @Schema(description = "티켓 좌석 위치", example = "통로")
    String seatPosition,

    @Schema(description = "수량", example = "1")
    int amount,

    @Schema(description = "한 매 가격", example = "150000")
    int price
) {

    public static TicketResponse from(TicketResult result) {
        return new TicketResponse(
            result.id(),
            result.date(),
            result.detailName(),
            result.area(),
            result.seatColumn(),
            result.seatType(),
            result.seatPosition(),
            result.amount(),
            result.price()
        );
    }
}
