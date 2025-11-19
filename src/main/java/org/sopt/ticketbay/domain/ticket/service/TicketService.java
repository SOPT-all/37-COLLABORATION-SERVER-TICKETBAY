package org.sopt.ticketbay.domain.ticket.service;

import static org.sopt.ticketbay.domain.event.domain.exception.EventErrorCode.EVENT_NOT_FOUND;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.exception.EventException;
import org.sopt.ticketbay.domain.event.repository.EventRepository;
import org.sopt.ticketbay.domain.ticket.repository.TicketCustomRepository;
import org.sopt.ticketbay.domain.ticket.repository.TicketRepository;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketResult;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketCustomRepository ticketCustomRepository;
    private final EventRepository eventRepository;

    public List<TicketResult> getTickets(Long eventId, LocalDate date) {
        validateEvent(eventId);

        return ticketCustomRepository.findTickets(eventId, date)
            .stream()
            .map(TicketResult::from)
            .toList();
    }

    private void validateEvent(Long eventId) {
        if(!eventRepository.existsById(eventId)) {
            throw new EventException(EVENT_NOT_FOUND);
        }
    }

}
