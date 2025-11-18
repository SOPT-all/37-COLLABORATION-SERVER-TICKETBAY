package org.sopt.ticketbay.domain.user.repository;

import org.sopt.ticketbay.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
