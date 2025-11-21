package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketDetailResult;

@Schema(description = "티켓 상세 조회 DTO")
public record TicketDetailResponse(

    @Schema(description = "티켓 ID", example = "1")
    Long id,

    @Schema(description = "상품 번호", example = "9702343334630")
    Long productNumber,

    @Schema(description = "티켓 관련 행사 정보")
    EventResponse event,

    @Schema(description = "티켓 관련 좌석 정보")
    SeatResponse seat,

    @Schema(description = "티켓 보유 여부", example = "true")
    boolean status,

    @Schema(description = "티켓 당 가격", example = "150000")
    int pricePerTicket,

    @Schema(description = "수량", example = "1")
    int amount,

    @Schema(description = "총 가격", example = "150000")
    int totalPrice,

    @Schema(description = "등록 일시", example = "2025-11-19T23:13:01")
    LocalDateTime createdAt
) {

    public static TicketDetailResponse from(TicketDetailResult result) {
        return new TicketDetailResponse(
            result.id(),
            result.productNumber(),
            EventResponse.from(result.event()),
            SeatResponse.from(result.seat()),
            result.status(),
            result.pricePerTicket(),
            result.amount(),
            result.pricePerTicket() * result.amount(),
            result.createdAt()
        );
    }
}
