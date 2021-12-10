package com.sirenk.core.user.infrastructure.user;

import com.sirenk.core.common.exception.EntityDuplicationException;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.response.ErrorCode;
import com.sirenk.core.user.domain.user.User;
import com.sirenk.core.user.domain.user.UserStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserStorerImpl implements UserStorer {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User store(User user) {
        if (user == null) throw new InvalidParamException("user is null");

        try {
            return userJpaRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("user_idx03")) {
                throw new EntityDuplicationException(ErrorCode.ENTITY_DUPLICATION.getErrorMsg("EMAIL"));
            }
            throw new EntityDuplicationException();
        }
    }

    @Override
    public void remove(User user) {
        if (user == null) throw new InvalidParamException("user is null");
        userJpaRepository.delete(user);
    }

}
