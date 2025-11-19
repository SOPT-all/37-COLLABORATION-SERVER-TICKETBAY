package org.sopt.ticketbay.domain.event.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class EventRepositoyImpl {

    private final JPAQueryFactory jpaQueryFactory;

    public Page<Event> findTopEventsByViewCount(Pageable pageable) {
        QEvent event = QEvent.event;

        List<Event> events = jpaQueryFactory
                .selectFrom(event)
                .orderBy(event.viewCount.desc()) // 조회수 기준 높은 순
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = jpaQueryFactory
                .select(event.count())
                .from(event)
                .fetchOne();

        return new PageImpl<>(events, pageable, total);
    }
}
