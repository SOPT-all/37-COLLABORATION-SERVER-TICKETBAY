package org.sopt.ticketbay.domain.history.repository;

import org.sopt.ticketbay.domain.history.domain.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

    Page<History> findRecentHistoryByUser(Long userId, Pageable pageable);

}
