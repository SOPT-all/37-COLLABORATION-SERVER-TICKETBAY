package org.sopt.ticketbay.domain.event.service.dto.response;

public record EventResult(
    Long id,
    String name,
    String place,
    boolean isTopRanking
) {

}
