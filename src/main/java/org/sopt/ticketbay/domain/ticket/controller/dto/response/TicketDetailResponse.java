package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import java.time.LocalDateTime;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketDetailResult;

public record TicketDetailResponse(
    Long id,
    Long productNumber,
    EventResponse event,
    SeatResponse seat,
    boolean status,
    int pricePerTicket,
    int amount,
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
            result.createdAt()
        );
    }
}
