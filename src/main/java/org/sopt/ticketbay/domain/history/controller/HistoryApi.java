package org.sopt.ticketbay.domain.history.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.ticketbay.domain.history.controller.dto.response.HistoryListResponse;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "History", description = "[뷰1] 최근 본 티켓 API")
public interface HistoryApi {

    @Operation(summary = "[뷰1] 최근 본 티켓 목록 조회", description = "특정 유저가 최근 본 티켓을 최신 순으로 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "최근 본 티켓 목록 조회 성공"),
        @ApiResponse(responseCode = "404", description = "해당 유저가 없어 최근 본 티켓 목록 조회 실패 ")
    })
    ResponseEntity<ApiResponseBody<HistoryListResponse, Void>> getRecentHistories(
        @Parameter(description = "조회할 유저 ID", example = "1", required = true)
        @PathVariable Long userId
    );
}
