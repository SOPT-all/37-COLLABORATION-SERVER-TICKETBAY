package org.sopt.ticketbay.domain.event.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.sopt.ticketbay.domain.event.repository.EventCustomRepository;
import org.sopt.ticketbay.domain.event.repository.EventRepository;
import org.sopt.ticketbay.domain.event.service.dto.response.EventListResult;
import org.sopt.ticketbay.domain.event.service.dto.response.EventResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventCustomRepository eventCustomRepository;
    private final EventRepository eventRepository;

    public EventListResult getTopEvents(int page, int size) {
        List<Long> top5Ids = eventRepository.findTop5ByOrderByViewCountDesc()
            .stream()
            .map(Event::getId)
            .toList();

        Page<Event> pageData = eventCustomRepository.findTopEventsByViewCount(
            PageRequest.of(page, size)
        );

        List<EventResult> eventDtos = pageData.getContent().stream()
            .map(e -> new EventResult(
                e.getId(),
                e.getName(),
                e.getPlace(),
                top5Ids.contains(e.getId())
            ))
            .toList();

        return new EventListResult(
            eventDtos,
            pageData.getNumber(),
            pageData.getSize(),
            pageData.getTotalElements(),
            pageData.getTotalPages()
        );
    }
}
