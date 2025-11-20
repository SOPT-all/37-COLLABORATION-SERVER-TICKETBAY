package org.sopt.ticketbay.domain.history.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.controller.dto.response.HistoryResponse;
import org.sopt.ticketbay.domain.history.controller.dto.response.HistoryListResponse;
import org.sopt.ticketbay.domain.history.service.HistoryService;
import org.sopt.ticketbay.domain.user.validator.UserValidator;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.sopt.ticketbay.domain.history.controller.message.HistorySuccessCode.HISTORY_LIST_RETRIEVED_SUCCESS;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class HistoryController {

    private final HistoryService historyService;
    private final UserValidator userValidator;

    @GetMapping("/users/{userId}/recent")
    public ResponseEntity<ApiResponseBody<HistoryListResponse, Void>> getRecentHistories(
            @PathVariable Long userId
    ) {
        userValidator.validateUser(userId);

        List<HistoryResponse> historyResponses = historyService.getAllHistories(userId)
                .stream()
                .map(HistoryResponse::from)
                .toList();

        HistoryListResponse response = new HistoryListResponse(historyResponses);

        return ResponseEntity.ok(ApiResponseBody.ok(HISTORY_LIST_RETRIEVED_SUCCESS, response));
    }

}
