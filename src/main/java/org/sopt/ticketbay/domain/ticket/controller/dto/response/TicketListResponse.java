package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "특정 행사와 관련된 티켓 목록 DTO")
public record TicketListResponse(

    @Schema(description = "관련 티켓 목록")
    List<TicketResponse> tickets
) {

    public static TicketListResponse from(List<TicketResponse> ticketResponseList) {
        return new TicketListResponse(ticketResponseList);
    }
}
