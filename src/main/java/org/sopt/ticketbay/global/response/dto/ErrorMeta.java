package org.sopt.ticketbay.global.response.dto;

import java.time.Instant;

public record ErrorMeta(
    String path,
    Instant timestamp
) {

}
