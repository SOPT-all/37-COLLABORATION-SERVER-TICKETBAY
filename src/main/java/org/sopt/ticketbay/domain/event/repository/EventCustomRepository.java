package org.sopt.ticketbay.domain.event.repository;

import org.sopt.ticketbay.domain.event.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventCustomRepository {

    Page<Event> findTopEventsByViewCount(Pageable pageable);
}
