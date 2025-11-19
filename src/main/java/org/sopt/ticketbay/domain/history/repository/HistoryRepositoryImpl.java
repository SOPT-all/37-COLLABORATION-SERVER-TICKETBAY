package org.sopt.ticketbay.domain.history.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.history.domain.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class HistoryRepositoryImpl {

    private final JPAQueryFactory jpaQueryFactory;

    Page<History> findRecentHistoryByUser(Long userId, Pageable pageable){
        QHistory history = QHistory.history;

        List<History> historyList = jpaQueryFactory
                .selectFrom(history)
                .where(history.user.id.eq(userId))
                .orderBy(history.lastViewedAt.desc()) // 최신순
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = jpaQueryFactory
                .select(history.count())
                .from(history)
                .where(history.user.id.eq(userId))
                .fetchOne();

        return new PageImpl<>(historyList, pageable, total);
    };

}
