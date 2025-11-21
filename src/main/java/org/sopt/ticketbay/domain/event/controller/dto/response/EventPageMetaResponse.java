package org.sopt.ticketbay.domain.event.controller.dto.response;

import org.sopt.ticketbay.domain.event.domain.Event;
import org.springframework.data.domain.Page;

public record EventPageMetaResponse(
    int page,
    int size,
    long totalElements,
    int totalPages
) {

    public static EventPageMetaResponse from(Page<Event> pageData) {
        return new EventPageMetaResponse(
            pageData.getNumber(),
            pageData.getSize(),
            pageData.getTotalElements(),
            pageData.getTotalPages()
        );
    }
}
