package com.sirenk.core.user.infrastructure.authority;

import com.sirenk.core.common.exception.EntityNotFoundException;
import com.sirenk.core.user.domain.authoiry.Authority;
import com.sirenk.core.user.domain.authoiry.AuthorityReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorityReaderImpl implements AuthorityReader {

    private final AuthorityJpaRepository authorityJpaRepository;

    @Override
    public Authority read(Long id) {
        return authorityJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Authority read(String token) {
        return authorityJpaRepository.findByToken(token)
                .orElseThrow(EntityNotFoundException::new);
    }

}
