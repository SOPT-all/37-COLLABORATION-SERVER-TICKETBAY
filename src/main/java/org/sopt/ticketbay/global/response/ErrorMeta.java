package org.sopt.ticketbay.global.response;

import java.time.Instant;

public record ErrorMeta(
    String path,
    Instant timestamp
) {

}
