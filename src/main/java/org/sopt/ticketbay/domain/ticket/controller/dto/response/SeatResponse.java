package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import org.sopt.ticketbay.domain.ticket.service.dto.response.SeatInfo;

public record SeatResponse(
    int area,
    int seatColumn,
    String seatType,
    String seatImageUrl
) {

    public static SeatResponse from(SeatInfo seatInfo) {
        return new SeatResponse(
            seatInfo.area(),
            seatInfo.seatColumn(),
            seatInfo.seatType(),
            seatInfo.seatImageUrl()
        );
    }
}
