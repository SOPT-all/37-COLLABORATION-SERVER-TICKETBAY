package org.sopt.ticketbay.domain.event.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.sopt.ticketbay.domain.event.domain.enums.MainCategory;
import org.sopt.ticketbay.domain.event.repository.EventCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class EventServiceTest {

    @Mock
    private EventCustomRepository eventCustomRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("인기 이벤트 조회: 페이지네이션 형식으로 조회")
    void getTopEvents() {
        // given
        int page = 0;
        int size = 10;
        Instant now = Instant.now();

        Event event1 = Event.create(
                "콘서트a",
                "세부공연명a",
                now,
                MainCategory.CONCERT,
                "락",
                "서울 올림픽홀",
                100L
        );

        Event event2 = Event.create(
                "콘서트b",
                "세부공연명b",
                now,
                MainCategory.CONCERT,
                "발라드",
                "서울 체조경기장",
                95L
        );


        List<Event> eventList = List.of(event1, event2);
        Page<Event> mockPage = new PageImpl<>(eventList);

        when(eventCustomRepository.findTopEventsByViewCount(PageRequest.of(page, size)))
                .thenReturn(mockPage);

        // when
        Page<Event> result = eventService.getTopEvents(page, size);

        // then
        assertThat(result.getContent().size()).isEqualTo(2);
        assertThat(result.getContent()).contains(event1, event2);

        verify(eventCustomRepository, times(1))
                .findTopEventsByViewCount(PageRequest.of(page, size));
    }
}
