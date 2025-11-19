package org.sopt.ticketbay.domain.ticket.service.dto.response;

import java.time.Instant;
import org.sopt.ticketbay.domain.ticket.domain.Ticket;

public record TicketResult(
    Instant date,
    String detailName,
    int area,
    int seatColumn,
    String seatType,
    String seatPosition,
    int amount,
    int price
) {

    public static TicketResult from(Ticket ticket) {
        return new TicketResult(
            ticket.getEvent().getEventDate(),
            ticket.getEvent().getDetailName(),
            ticket.getSeat().getArea(),
            ticket.getSeat().getSeatColumn(),
            ticket.getSeat().getSeatType(),
            ticket.getSeat().getPositionName(),
            ticket.getAmount(),
            ticket.getPrice()
        );
    }
}
