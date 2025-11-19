package org.sopt.ticketbay.domain.history.repository;

import org.sopt.ticketbay.domain.history.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

}
