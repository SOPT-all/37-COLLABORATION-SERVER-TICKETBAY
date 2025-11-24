package org.sopt.ticketbay.domain.event.controller;

import static org.sopt.ticketbay.domain.event.controller.message.EventSuccessCode.EVENT_TOP_LIST_RETRIEVED_SUCCESS;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.controller.dto.response.EventListResponse;
import org.sopt.ticketbay.domain.event.controller.dto.response.EventPageMetaResponse;
import org.sopt.ticketbay.domain.event.controller.dto.response.EventResponse;
import org.sopt.ticketbay.domain.event.service.EventService;
import org.sopt.ticketbay.domain.event.service.dto.response.EventListResult;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class EventController implements EventApi {

    private final EventService eventService;

    @Override
    @GetMapping("/events/top")
    public ResponseEntity<ApiResponseBody<EventListResponse, EventPageMetaResponse>> getTopEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        EventListResult serviceData =
            eventService.getTopEvents(page, size);

        List<EventResponse> responses = serviceData.events().stream()
            .map(EventResponse::from)
            .toList();

        return ResponseEntity.ok(
            ApiResponseBody.ok(
                EVENT_TOP_LIST_RETRIEVED_SUCCESS,
                EventListResponse.from(responses),
                EventPageMetaResponse.from(serviceData)
            )
        );
    }
}

