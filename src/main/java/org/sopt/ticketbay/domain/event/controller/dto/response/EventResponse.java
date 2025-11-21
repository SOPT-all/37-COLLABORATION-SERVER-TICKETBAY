package org.sopt.ticketbay.domain.event.controller.dto.response;

import org.sopt.ticketbay.domain.event.domain.Event;

import java.time.Instant;

public record EventResponse(
        Long id,
        String name,
        String place
) {

    public static EventResponse from(Event event) {
        return new EventResponse(
                event.getId(),
                event.getName(),
                event.getPlace()
        );
    }
}
