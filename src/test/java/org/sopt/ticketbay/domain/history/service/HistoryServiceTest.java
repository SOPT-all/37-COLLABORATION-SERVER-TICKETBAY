package org.sopt.ticketbay.domain.history.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.sopt.ticketbay.domain.event.domain.enums.MainCategory;
import org.sopt.ticketbay.domain.history.domain.History;
import org.sopt.ticketbay.domain.history.repository.HistoryCustomRepository;
import org.sopt.ticketbay.domain.user.domain.User;
import org.sopt.ticketbay.domain.user.validator.UserValidator;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ActiveProfiles("test")
class HistoryServiceTest {

    @Mock
    private HistoryCustomRepository historyRepository;

    @Mock
    private UserValidator userValidator;

    @InjectMocks
    private HistoryService historyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("모든 히스토리 조회")
    void getAllHistories_shouldReturnHistories() {
        // given
        Long userId = 1L;
        User user = User.create("testUser");

        Event event1 = Event.create(
                "콘서트a",
                "세부공연명a",
                Instant.now(),
                MainCategory.CONCERT,
                "락",
                "서울 올림픽홀",
                100L
        );

        Event event2 = Event.create(
                "콘서트b",
                "세부공연명b",
                Instant.now(),
                MainCategory.CONCERT,
                "발라드",
                "서울 체조경기장",
                95L
        );

        History h1 = History.create(user, event1, Instant.now());
        History h2 = History.create(user, event2, Instant.now());

        List<History> histories = Arrays.asList(h1, h2);

        when(historyRepository.findAllByUserOrderByLastViewedDesc(userId)).thenReturn(histories);

        // when
        List<History> result = historyService.getAllHistories(userId);

        // then
        verify(userValidator, times(1)).validateUser(userId);
        verify(historyRepository, times(1)).findAllByUserOrderByLastViewedDesc(userId);

        assertEquals(2, result.size());
        assertEquals(histories, result);
    }
}
