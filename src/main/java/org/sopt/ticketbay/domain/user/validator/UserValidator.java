package org.sopt.ticketbay.domain.user.validator;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.user.domain.exception.UserException;
import org.sopt.ticketbay.domain.user.repository.UserRepository;
import org.springframework.stereotype.Component;

import static org.sopt.ticketbay.domain.user.domain.exception.UserErrorCode.USER_NOT_FOUND;

@RequiredArgsConstructor
@Component
public class UserValidator {

    private final UserRepository userRepository;

    public void validateUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserException(USER_NOT_FOUND);
        }
    }
}
