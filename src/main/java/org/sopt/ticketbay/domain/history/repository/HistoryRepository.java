package org.sopt.ticketbay.domain.history.repository;

import org.sopt.ticketbay.domain.history.domain.History;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findAllByUserOrderByLastViewedDesc(Long userId);

}
