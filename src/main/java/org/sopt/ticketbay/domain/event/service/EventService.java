package org.sopt.ticketbay.domain.event.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.sopt.ticketbay.domain.event.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    public Page<Event> getTopEvents(int page, int size) {
        return eventRepository.findTopEventsByViewCount(PageRequest.of(page, size));
    }
}
