package org.sopt.ticketbay.domain.ticket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import org.sopt.ticketbay.domain.ticket.controller.dto.response.TicketDetailResponse;
import org.sopt.ticketbay.domain.ticket.controller.dto.response.TicketListResponse;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "03 - Ticket", description = "[뷰2, 뷰3] 티켓 관련 API")
public interface TicketApi {

    @Operation(summary = "[뷰2] 티켓 목록 조회", description = "지정된 행사와 연관된 티켓 목록을 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "티켓 목록 조회 성공"),
        @ApiResponse(responseCode = "404", description = "해당 이벤트 ID가 없어 티켓 목록 조회 실패")
    })
    ResponseEntity<ApiResponseBody<TicketListResponse, Void>> getTicketList(
        @Parameter(description = "조회할 이벤트 ID", example = "1", required = true)
        @PathVariable Long eventId,

        @Parameter(description = "필터링할 날짜", example = "2025-10-31")
        @RequestParam(required = false) LocalDate date
    );

    @Operation(summary = "[뷰3] 티켓 상세 조회", description = "해당 티켓의 상세 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "티켓 상세 조회 성공"),
        @ApiResponse(responseCode = "404", description = "해당 티켓 ID가 없어 티켓 상세 조회 실패")
    })
    ResponseEntity<ApiResponseBody<TicketDetailResponse, Void>> getTicketDetail(
        @Parameter(description = "조회할 티켓 ID", example = "1", required = true)
        @PathVariable Long ticketId
    );

}
