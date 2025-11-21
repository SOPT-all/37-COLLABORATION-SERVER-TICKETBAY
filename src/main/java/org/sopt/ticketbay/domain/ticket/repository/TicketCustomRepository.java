package org.sopt.ticketbay.domain.ticket.repository;

import java.time.LocalDate;
import java.util.List;
import org.sopt.ticketbay.domain.ticket.domain.Ticket;

public interface TicketCustomRepository {

    List<Ticket> findTickets(Long eventId, LocalDate date);

}
