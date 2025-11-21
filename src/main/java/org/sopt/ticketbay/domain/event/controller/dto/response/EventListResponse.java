package org.sopt.ticketbay.domain.event.controller.dto.response;

import java.util.List;

public record EventListResponse(
    List<EventResponse> events
) {

    public static EventListResponse from(List<EventResponse> events) {
        return new EventListResponse(events);
    }
}
