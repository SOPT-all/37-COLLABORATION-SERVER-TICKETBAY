package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import java.time.LocalDateTime;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketResult;

public record TicketResponse(
    LocalDateTime date,
    String detailName,
    int area,
    int seatColumn,
    String seatType,
    String seatPosition,
    int amount,
    int price
) {
    public static TicketResponse from(TicketResult result) {
        return new TicketResponse(
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

