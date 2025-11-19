package org.sopt.ticketbay.domain.ticket.repository;

import org.sopt.ticketbay.domain.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
