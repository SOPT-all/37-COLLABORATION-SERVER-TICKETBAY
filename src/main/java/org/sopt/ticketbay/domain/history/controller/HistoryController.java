package org.sopt.ticketbay.domain.history.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.service.HistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class HistoryController {

    private final HistoryService historyService;

}
