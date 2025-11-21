package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import java.time.LocalDateTime;
import org.sopt.ticketbay.domain.ticket.service.dto.response.EventInfo;

public record EventResponse(
    Long id,
    String mainCategory,
    String subCategory,
    String name,
    LocalDateTime date,
    String place,
    String detailName
) {

    public static EventResponse from(EventInfo eventInfo) {
        return new EventResponse(
            eventInfo.id(),
            eventInfo.mainCategory(),
            eventInfo.subCategory(),
            eventInfo.name(),
            eventInfo.date(),
            eventInfo.place(),
            eventInfo.detailName()
        );
    }
}
