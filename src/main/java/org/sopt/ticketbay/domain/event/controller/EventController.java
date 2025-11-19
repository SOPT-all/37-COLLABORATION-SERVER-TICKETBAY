package org.sopt.ticketbay.domain.event.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.service.EventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventService eventService;

}
