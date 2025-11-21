package org.sopt.ticketbay.domain.ticket.service.dto.response;

import java.time.LocalDateTime;
import org.sopt.ticketbay.domain.ticket.domain.Ticket;

public record TicketResult(
    LocalDateTime date,
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
            LocalDateTime.ofInstant(
                ticket.getEvent().getEventDate(),
                java.time.ZoneId.of("Asia/Seoul")
            ),
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
