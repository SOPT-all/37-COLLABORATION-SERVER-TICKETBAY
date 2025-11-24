package org.sopt.ticketbay.domain.event.service.dto.response;

import java.util.List;

public record EventListResult(
    List<EventResult> events,
    int page,
    int size,
    long totalElements,
    int totalPages
) {

}
