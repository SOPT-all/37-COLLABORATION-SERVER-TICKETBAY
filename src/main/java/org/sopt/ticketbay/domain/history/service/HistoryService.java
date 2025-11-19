package org.sopt.ticketbay.domain.history.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.domain.History;
import org.sopt.ticketbay.domain.history.repository.HistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private HistoryRepository historyRepository;

    public Page<History> getRecentHistories(Long userId, int page, int size) {
        return historyRepository.findRecentHistoryByUser(userId, PageRequest.of(page, size));
    }

}
