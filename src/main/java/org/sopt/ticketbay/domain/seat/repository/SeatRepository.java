package org.sopt.ticketbay.domain.seat.repository;

import org.sopt.ticketbay.domain.seat.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
