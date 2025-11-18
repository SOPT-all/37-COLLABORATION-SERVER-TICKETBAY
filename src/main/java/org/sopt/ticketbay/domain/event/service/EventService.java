package org.sopt.ticketbay.domain.event.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.repository.EventRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

}
