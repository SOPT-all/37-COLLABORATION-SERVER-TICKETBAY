package org.sopt.ticketbay.domain.ticket.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;

}
