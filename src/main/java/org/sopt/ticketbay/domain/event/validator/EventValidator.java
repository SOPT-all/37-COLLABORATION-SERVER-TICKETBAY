package org.sopt.ticketbay.domain.event.validator;

import static org.sopt.ticketbay.domain.event.domain.exception.EventErrorCode.EVENT_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.exception.EventException;
import org.sopt.ticketbay.domain.event.repository.EventRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventValidator {

    private final EventRepository eventRepository;

    public void validateEvent(Long eventId) {
        if(!eventRepository.existsById(eventId)) {
            throw new EventException(EVENT_NOT_FOUND);
        }
    }
}
