package org.sopt.ticketbay.domain.history.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.service.HistoryService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HistoryController {

    private final HistoryService historyService;

}
