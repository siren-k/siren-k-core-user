package com.sirenk.core.user.infrastructure.user;

import com.sirenk.core.common.exception.EntityDuplicationException;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.response.ErrorCode;
import com.sirenk.core.user.domain.user.User;
import com.sirenk.core.user.domain.user.UserStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
        if (StringUtils.isEmpty(user.getName())) throw new InvalidParamException("user.getName()");
        if (StringUtils.isEmpty(user.getEmail())) throw new InvalidParamException("user.getEmail()");
        if (StringUtils.isEmpty(user.getPassword())) throw new InvalidParamException("user.getPassword()");

        try {
            return userJpaRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("user_idx01")) {
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
