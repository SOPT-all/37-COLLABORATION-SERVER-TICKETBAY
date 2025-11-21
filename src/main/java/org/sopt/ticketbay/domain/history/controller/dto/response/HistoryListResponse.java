package org.sopt.ticketbay.domain.history.controller.dto.response;

import java.util.List;

public record HistoryListResponse(
        List<HistoryResponse> histories
) {

}
