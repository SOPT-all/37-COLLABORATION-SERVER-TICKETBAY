package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketResult;


public record TicketDetailResponse(
    Long id,
    Long productNumber,
    String mainCategory,
    String subCategory,
    String name,
    LocalDateTime date,
    String place,
    String detailName,
    int area,
    int seatColumn,
    String seatType,
    String seatImageUrl,
    boolean status,
    int pricePerTicket,
    int amount,
    LocalDateTime createdAt
) {

    public static TicketDetailResponse from(TicketResult result) {
        return new TicketDetailResponse(
            result.id(),
            result.productNumber(),
            result.mainCategory(),
            result.subCategory(),
            result.name(),
            toLocalDateTime(result.date()),
            result.place(),
            result.detailName(),
            result.area(),
            result.seatColumn(),
            result.seatType(),
            result.seatImageUrl(),
            result.status(),
            result.pricePerTicket(),
            result.amount(),
            toLocalDateTime(result.createdAt())
        );
    }

    private static LocalDateTime toLocalDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }

        return LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Seoul"));
    }
}
