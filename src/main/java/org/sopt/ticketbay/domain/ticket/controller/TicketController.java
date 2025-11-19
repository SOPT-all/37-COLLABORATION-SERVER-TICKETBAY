package org.sopt.ticketbay.domain.ticket.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.ticket.service.TicketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

}
