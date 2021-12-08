package com.sirenk.core.user.infrastructure.program.api;

import com.sirenk.core.common.exception.EntityNotFoundException;
import com.sirenk.core.user.domain.program.api.Api;
import com.sirenk.core.user.domain.program.api.ApiReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiReaderImpl implements ApiReader {

    private final ApiJpaRepository apiJpaRepository;

    @Override
    public Api read(Long id) {
        return apiJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Api read(String token) {
        return apiJpaRepository.findByToken(token)
                .orElseThrow(EntityNotFoundException::new);
    }

}
