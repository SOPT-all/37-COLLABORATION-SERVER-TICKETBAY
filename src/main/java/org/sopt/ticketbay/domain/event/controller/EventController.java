package org.sopt.ticketbay.domain.event.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.service.EventService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventService eventService;

}
