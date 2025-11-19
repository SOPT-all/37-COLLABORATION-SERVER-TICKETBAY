package org.sopt.ticketbay.domain.history.controller.dto.response;

import java.util.List;

public record RecentHistoryListResponse(
        List<HistoryResponse> histories
) {
    public RecentHistoryListResponse(List<HistoryResponse> histories) {
        this.histories = histories;
    }
}
