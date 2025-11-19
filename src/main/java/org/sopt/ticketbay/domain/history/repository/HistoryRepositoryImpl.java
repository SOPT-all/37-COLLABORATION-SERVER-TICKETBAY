package org.sopt.ticketbay.domain.history.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.domain.History;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class HistoryRepositoryImpl {

    private final JPAQueryFactory jpaQueryFactory;

    public List<History> findAllByUserOrderByLastViewedAsc(Long userId) {
        QHistory history = QHistory.history;

        return jpaQueryFactory
                .selectFrom(history)
                .where(history.user.id.eq(userId))
                .orderBy(history.lastViewedAt.asc()) // 최근 조회 -> 이전 조회
                .fetch();
    }

}
