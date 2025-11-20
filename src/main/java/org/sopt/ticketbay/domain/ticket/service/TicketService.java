package org.sopt.ticketbay.domain.ticket.service;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.validator.EventValidator;
import org.sopt.ticketbay.domain.ticket.repository.TicketCustomRepository;
import org.sopt.ticketbay.domain.ticket.repository.TicketRepository;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketResult;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketCustomRepository ticketCustomRepository;
    private final EventValidator eventValidator;

    public List<TicketResult> getTickets(Long eventId, LocalDate date) {
        eventValidator.validateEvent(eventId);

        return ticketCustomRepository.findTickets(eventId, date)
            .stream()
            .map(TicketResult::from)
            .toList();
    }

}
