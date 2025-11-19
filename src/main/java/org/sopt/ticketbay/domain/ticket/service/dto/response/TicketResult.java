package org.sopt.ticketbay.domain.ticket.service.dto.response;

import java.time.Instant;
import org.sopt.ticketbay.domain.ticket.domain.Ticket;

public record TicketResult(
    Long id,
    Long productNumber,
    String mainCategory,
    String subCategory,
    String name,
    Instant date,
    String place,
    String detailName,
    int area,
    int seatColumn,
    String seatType,
    String seatImageUrl,
    boolean status,
    int pricePerTicket,
    int amount,
    Instant createdAt
) {

    public static TicketResult of(Ticket ticket, String seatImageUrl) {
        return new TicketResult(
            ticket.getId(),
            ticket.getProductNumber(),
            ticket.getEvent().getMainCategory().toString(),
            ticket.getEvent().getSubCategory(),
            ticket.getEvent().getName(),
            ticket.getEvent().getEventDate(),
            ticket.getEvent().getPlace(),
            ticket.getEvent().getDetailName(),
            ticket.getSeat().getArea(),
            ticket.getSeat().getSeatColumn(),
            ticket.getSeat().getSeatType(),
            seatImageUrl,
            ticket.isStatus(),
            ticket.getPrice(),
            ticket.getAmount(),
            ticket.getCreatedAt()
        );
    }
}
