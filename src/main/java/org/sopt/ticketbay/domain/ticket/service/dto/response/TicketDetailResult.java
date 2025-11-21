package org.sopt.ticketbay.domain.ticket.service.dto.response;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.sopt.ticketbay.domain.ticket.domain.Ticket;

public record TicketDetailResult(
    Long id,
    Long productNumber,
    EventInfo event,
    SeatInfo seat,
    boolean status,
    int pricePerTicket,
    int amount,
    LocalDateTime createdAt
) {

    public static TicketDetailResult from(Ticket ticket, String seatImageUrl) {
        return new TicketDetailResult(
            ticket.getId(),
            ticket.getProductNumber(),
            EventInfo.from(ticket.getEvent()),
            SeatInfo.from(ticket.getSeat(), seatImageUrl),
            ticket.isStatus(),
            ticket.getPrice(),
            ticket.getAmount(),
            LocalDateTime.ofInstant(ticket.getCreatedAt(), ZoneOffset.UTC)
        );
    }
}
