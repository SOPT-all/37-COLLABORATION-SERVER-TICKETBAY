package org.sopt.ticketbay.domain.event.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.ticketbay.domain.event.controller.dto.response.EventListResponse;
import org.sopt.ticketbay.domain.event.controller.dto.response.EventPageMetaResponse;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "02 - Event", description = "[뷰1] 베스트 인기티켓 API")
public interface EventApi {

    @Operation(summary = "[뷰1] 베스트 인기티켓 목록 조회", description = "사람들이 많이 조회한 행사를 조회수가 높은 순으로 반환합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "베스트 인기티켓 목록 조회 성공"),
    })
    ResponseEntity<ApiResponseBody<EventListResponse, EventPageMetaResponse>> getTopEvents(
        @Parameter(description = "조회할 페이지 순서. 엔드포인트에 명시하지 않고 요청할 경우 기본 값 0", example = "1")
        @RequestParam(defaultValue = "0") int page,

        @Parameter(description = "한 번에 가져올 페이지 양. 엔드포인트에 명시하지 않고 요청할 경우 기본 값 1", example = "10")
        @RequestParam(defaultValue = "10") int size
    );
}
