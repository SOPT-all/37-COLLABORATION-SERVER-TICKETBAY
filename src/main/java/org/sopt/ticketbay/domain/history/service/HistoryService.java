package org.sopt.ticketbay.domain.history.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.domain.History;
import org.sopt.ticketbay.domain.history.repository.HistoryCustomRepository;
import org.sopt.ticketbay.domain.user.validator.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private final HistoryCustomRepository historyRepository;
    private final UserValidator userValidator;

    public List<History> getAllHistories(Long userId) {
        userValidator.validateUser(userId);

        return historyRepository.findAllByUserOrderByLastViewedDesc(userId);
    }

}
