package com.sirenk.core.user.infrastructure.user;

import com.sirenk.core.user.domain.user.User;
import com.sirenk.core.user.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User read(Long id) {
        return userJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User read(String token) {
        return userJpaRepository.findByToken(token)
                .orElseThrow(EntityNotFoundException::new);
    }

}
