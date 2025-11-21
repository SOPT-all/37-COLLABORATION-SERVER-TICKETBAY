package org.sopt.ticketbay.domain.history.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "최근 본 티켓 목록 DTO")
public record HistoryListResponse(

    @Schema(description = "최근 본 티켓 목록")
    List<HistoryResponse> histories
) {

}
