package org.sopt.ticketbay.domain.ticket.controller;

import static org.sopt.ticketbay.domain.ticket.controller.message.TicketSuccessCode.TICKET_LIST_RETRIEVED_SUCCESS;

import java.time.LocalDate;
import java.util.List;
import static org.sopt.ticketbay.domain.ticket.controller.message.TicketSuccessCode.TICKET_DETAIL_RETRIEVED_SUCCESS;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.ticket.controller.dto.response.TicketListResponse;
import org.sopt.ticketbay.domain.ticket.controller.dto.response.TicketResponse;
import org.sopt.ticketbay.domain.ticket.controller.dto.response.TicketDetailResponse;
import org.sopt.ticketbay.domain.ticket.service.TicketService;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketDetailResult;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketResult;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/events/{eventId}/tickets")
    public ResponseEntity<ApiResponseBody<TicketListResponse, Void>> getTicketList(
        @PathVariable Long eventId,
        @RequestParam(required = false) LocalDate date
    ) {
        List<TicketResult> ticketResults = ticketService.getTickets(eventId, date);

        TicketListResponse response  = TicketListResponse.from(
            ticketResults.stream()
            .map(TicketResponse::from)
            .toList()
        );

        return ResponseEntity.ok(ApiResponseBody.ok(TICKET_LIST_RETRIEVED_SUCCESS, response));
    }

    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<ApiResponseBody<TicketDetailResponse, Void>> getTicketDetail(
        @PathVariable Long ticketId
    ) {
        TicketDetailResult ticketResult = ticketService.getTicketDetail(ticketId);
        TicketDetailResponse resonse = TicketDetailResponse.from(ticketResult);

        return ResponseEntity.ok(ApiResponseBody.ok(TICKET_DETAIL_RETRIEVED_SUCCESS, resonse));
    }

}
