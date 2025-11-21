package org.sopt.ticketbay.domain.event.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.sopt.ticketbay.domain.event.repository.EventCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventCustomRepository eventCustomRepository;

    public Page<Event> getTopEvents(int page, int size) {
        return eventCustomRepository.findTopEventsByViewCount(PageRequest.of(page, size));
    }
}
