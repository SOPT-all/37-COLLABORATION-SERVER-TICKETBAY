package org.sopt.ticketbay.domain.history.controller.dto.response;

import org.sopt.ticketbay.domain.history.domain.History;

import java.time.Instant;

public record HistoryResponse(
        Long eventId,
        String name,
        Instant lastViewedAt
) {
    public static HistoryResponse from(History history) {
        return new HistoryResponse(
                history.getEvent().getId(),
                history.getEvent().getName(),
                history.getLastViewedAt()
        );
    }
}
