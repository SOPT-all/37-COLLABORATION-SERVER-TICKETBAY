package org.sopt.ticketbay.domain.event.controller.dto.response;

import org.sopt.ticketbay.domain.event.domain.Event;

import java.util.List;

public record EventListResponse(
        List<EventResponse> events,
        int page,
        int size,
        long totalElements,
        int totalPages
) {

    public static EventListResponse from(List<EventResponse> events,
                                         int page,
                                         int size,
                                         long totalElements,
                                         int totalPages) {
        return new EventListResponse(events, page, size, totalElements, totalPages);
    }

    public static EventListResponse fromPage(org.springframework.data.domain.Page<Event> pageData) {
        List<EventResponse> eventResponses = pageData.stream()
                .map(EventResponse::from)
                .toList();
        return new EventListResponse(
                eventResponses,
                pageData.getNumber(),
                pageData.getSize(),
                pageData.getTotalElements(),
                pageData.getTotalPages()
        );
    }
}
