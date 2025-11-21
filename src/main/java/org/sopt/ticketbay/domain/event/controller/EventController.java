package org.sopt.ticketbay.domain.event.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.controller.dto.response.EventListResponse;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.sopt.ticketbay.domain.event.service.EventService;
import org.sopt.ticketbay.global.response.dto.ApiResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.sopt.ticketbay.domain.event.controller.message.EventSuccessCode.EVENT_TOP_LIST_RETRIEVED_SUCCESS;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventService eventService;

    @GetMapping("/events/top")
    public ResponseEntity<ApiResponseBody<EventListResponse, Void>> getTopEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Event> topEventsPage = eventService.getTopEvents(page, size);

        EventListResponse response = EventListResponse.fromPage(topEventsPage);

        return ResponseEntity.ok(ApiResponseBody.ok(EVENT_TOP_LIST_RETRIEVED_SUCCESS, response));
    }
}

