package org.sopt.ticketbay.domain.ticket.controller;

import static org.sopt.ticketbay.domain.ticket.controller.message.TicketSuccessCode.TICKET_DETAIL_RETRIEVED_SUCCESS;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.ticket.controller.dto.response.TicketDetailResponse;
import org.sopt.ticketbay.domain.ticket.service.TicketService;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketResult;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<ApiResponseBody<TicketDetailResponse, Void>> getTicketDetail(
        @PathVariable Long ticketId
    ) {
        TicketResult ticketResult = ticketService.getTicketDetail(ticketId);
        TicketDetailResponse resonse = TicketDetailResponse.from(ticketResult);

        return ResponseEntity.ok(ApiResponseBody.ok(TICKET_DETAIL_RETRIEVED_SUCCESS, resonse));
    }

}
