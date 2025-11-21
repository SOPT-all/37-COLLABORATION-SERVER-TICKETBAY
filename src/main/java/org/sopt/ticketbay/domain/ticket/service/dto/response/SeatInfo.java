package org.sopt.ticketbay.domain.ticket.service.dto.response;

import org.sopt.ticketbay.domain.seat.domain.Seat;

public record SeatInfo(
    Long id,
    int area,
    int seatColumn,
    String seatType,
    String seatImageUrl
) {

    public static SeatInfo from(Seat seat, String seatImageUrl) {
        return new SeatInfo(
            seat.getId(),
            seat.getArea(),
            seat.getSeatColumn(),
            seat.getSeatType(),
            seatImageUrl
        );
    }
}
