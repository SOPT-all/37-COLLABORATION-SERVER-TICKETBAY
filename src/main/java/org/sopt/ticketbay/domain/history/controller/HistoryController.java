package org.sopt.ticketbay.domain.history.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.controller.dto.response.HistoryResponse;
import org.sopt.ticketbay.domain.history.controller.dto.response.RecentHistoryListResponse;
import org.sopt.ticketbay.domain.history.domain.History;
import org.sopt.ticketbay.domain.history.service.HistoryService;
import org.sopt.ticketbay.domain.user.validator.UserValidator;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.sopt.ticketbay.domain.history.controller.message.HistorySuccessCode.HISTORY_LIST_RETRIEVED_SUCCESS;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class HistoryController {

    private final HistoryService historyService;
    private final UserValidator userValidator;

    // 최근 조회 내역 리스트 조회 API
    @GetMapping("/users/{userId}/recent")
    public ResponseEntity<ApiResponseBody<RecentHistoryListResponse, Void>> getRecentHistories(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        userValidator.validateUser(userId);
        Page<History> historiesPage = historyService.getRecentHistories(userId, page, size);

        RecentHistoryListResponse response = RecentHistoryListResponse.from(
                historiesPage.map(HistoryResponse::from).toList(),
                historiesPage.getNumber(),
                historiesPage.getSize(),
                historiesPage.getTotalElements(),
                historiesPage.getTotalPages()
        );

        return ResponseEntity.ok(ApiResponseBody.ok(HISTORY_LIST_RETRIEVED_SUCCESS, response));
    }

}
