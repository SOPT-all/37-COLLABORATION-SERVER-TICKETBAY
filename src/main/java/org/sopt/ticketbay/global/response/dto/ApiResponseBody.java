package org.sopt.ticketbay.global.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.ticketbay.global.response.code.ErrorCode;
import org.sopt.ticketbay.global.response.code.SuccessCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponseBody<T, M>(

    @Schema(description = "해당 API의 성공 여부를 반환합니다. true면 성공, false면 실패입니다.")
    boolean success,

    @Schema(description = "해당 API의 HTTP 상태 코드입니다.")
    int status,

    @Schema(description = "해당 API의 결과에 대한 상태 메시지입니다.")
    String message,

    @Schema(description = "해당 API에서 반환하는 결과 데이터입니다.")
    T data,

    @Schema(description = "해당 API 관련 커스텀 코드입니다. 도메인(3글자)-상태코드-순번 으로 이루어져 있습니다.", example = "TIC_200_001")
    String code,

    @Schema(description = "해당 API의 data를 설명하는 meta data입니다. 페이지네이션 정보나, 에러 발생 시 에러 정보를 반환합니다.")
    M meta
) {

    public static ApiResponseBody<Void, Void> ok(SuccessCode successCode) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getMessage(),
            null,
            null,
            null
        );
    }

    public static <T> ApiResponseBody<T, Void> ok(SuccessCode successCode, T data) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getMessage(),
            data,
            null,
            null
        );
    }

    public static <T> ApiResponseBody<T, Void> created(SuccessCode successCode, T data) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getMessage(),
            data,
            null,
            null
        );
    }

    public static ApiResponseBody<Void, ErrorMeta> onFailure(
        ErrorCode errorCode,
        ErrorMeta errorMeta
    ) {
        return new ApiResponseBody<>(
            false,
            errorCode.getStatus(),
            errorCode.getMessage(),
            null,
            errorCode.getCode(),
            errorMeta
        );
    }

    public static ApiResponseBody<Void, ErrorMeta> onFailure(
        ErrorCode errorCode,
        String message,
        ErrorMeta errorMeta
    ) {
        return new ApiResponseBody<>(
            false,
            errorCode.getStatus(),
            message,
            null,
            errorCode.getCode(),
            errorMeta
        );
    }

    @Override
    public T data() {
        return data;
    }
}
