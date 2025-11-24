package org.sopt.ticketbay.domain.event.repository;

import java.util.List;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findTop5ByOrderByViewCountDesc();

}
