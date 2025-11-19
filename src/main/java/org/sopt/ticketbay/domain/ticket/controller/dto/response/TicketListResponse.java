package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import java.util.List;

public record TicketListResponse(
    List<TicketResponse> tickets
) {
    public static TicketListResponse from(List<TicketResponse> ticketResponseList) {
        return new TicketListResponse(ticketResponseList);
    }
}
