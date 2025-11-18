package org.sopt.ticketbay.domain.history.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.repository.HistoryRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private HistoryRepository historyRepository;

}
