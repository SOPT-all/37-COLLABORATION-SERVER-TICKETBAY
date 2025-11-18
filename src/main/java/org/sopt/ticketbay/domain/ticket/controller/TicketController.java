package org.sopt.ticketbay.domain.ticket.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.ticket.service.TicketService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

}
