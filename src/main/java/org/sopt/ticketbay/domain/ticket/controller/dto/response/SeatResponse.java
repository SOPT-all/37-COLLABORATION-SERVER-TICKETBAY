package org.sopt.ticketbay.domain.ticket.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.ticketbay.domain.ticket.service.dto.response.SeatInfo;

@Schema(description = "티켓 상세 조회 시 해당 티켓의 좌석 정보 DTO")
public record SeatResponse(

    @Schema(description = "좌석 ID", example = "1")
    Long id,

    @Schema(description = "좌석 구역", example = "507")
    int area,

    @Schema(description = "좌석 열 정보", example = "2")
    int seatColumn,

    @Schema(description = "좌석 유형", example = "외야지정석")
    String seatType,

    @Schema(description = "해당 좌석 사진 s3 url. 1시간만 접근 가능한 이미지 링크를 보내드립니다!")
    String seatImageUrl
) {

    public static SeatResponse from(SeatInfo seatInfo) {
        return new SeatResponse(
            seatInfo.id(),
            seatInfo.area(),
            seatInfo.seatColumn(),
            seatInfo.seatType(),
            seatInfo.seatImageUrl()
        );
    }
}
