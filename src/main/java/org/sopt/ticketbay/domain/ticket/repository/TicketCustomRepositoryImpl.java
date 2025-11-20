package org.sopt.ticketbay.domain.ticket.repository;

import static org.sopt.ticketbay.domain.event.domain.QEvent.event;
import static org.sopt.ticketbay.domain.seat.domain.QSeat.seat;
import static org.sopt.ticketbay.domain.ticket.domain.QTicket.ticket;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.ticket.domain.Ticket;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TicketCustomRepositoryImpl implements TicketCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Ticket> findTickets(Long eventId, LocalDate date) {
        return jpaQueryFactory
            .selectFrom(ticket)
            .join(ticket.event, event).fetchJoin()
            .join(ticket.seat, seat).fetchJoin()
            .where(
                event.id.eq(eventId),
                dateEq(date)
            )
            .fetch();
    }

    private BooleanExpression dateEq(LocalDate date) {
        if (date == null) return null;

        return Expressions.dateTemplate(
            LocalDate.class,
            "DATE(CONVERT_TZ({0}, '+00:00', '+09:00'))",
            event.eventDate
        ).eq(date);
    }
}
