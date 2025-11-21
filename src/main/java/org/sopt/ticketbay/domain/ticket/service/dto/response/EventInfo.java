package org.sopt.ticketbay.domain.ticket.service.dto.response;

import java.time.LocalDateTime;
import org.sopt.ticketbay.domain.event.domain.Event;

public record EventInfo(
    Long id,
    String mainCategory,
    String subCategory,
    String name,
    LocalDateTime date,
    String place,
    String detailName
) {

    public static EventInfo from(Event event) {
        return new EventInfo(
            event.getId(),
            event.getMainCategory().getName(),
            event.getSubCategory(),
            event.getName(),
            LocalDateTime.ofInstant(
                event.getEventDate(),
                java.time.ZoneId.of("Asia/Seoul")
            ),
            event.getPlace(),
            event.getDetailName()
        );
    }
}
