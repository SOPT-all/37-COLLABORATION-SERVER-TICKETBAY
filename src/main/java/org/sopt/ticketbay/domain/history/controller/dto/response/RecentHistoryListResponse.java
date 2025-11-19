package org.sopt.ticketbay.domain.history.controller.dto.response;

import java.util.List;

public record RecentHistoryListResponse(
        List<HistoryResponse> histories,
        int page,
        int size,
        long totalElements,
        int totalPages
) {
    public static RecentHistoryListResponse from(List<HistoryResponse> historyResponses,
                                                 int page,
                                                 int size,
                                                 long totalElements,
                                                 int totalPages) {
        return new RecentHistoryListResponse(historyResponses, page, size, totalElements, totalPages);
    }
}
