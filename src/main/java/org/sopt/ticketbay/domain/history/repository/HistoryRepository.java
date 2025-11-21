package org.sopt.ticketbay.domain.history.repository;

import org.sopt.ticketbay.domain.history.domain.History;

import java.util.List;

public interface HistoryRepository {

    List<History> findAllByUserOrderByLastViewedDesc(Long userId);

}
