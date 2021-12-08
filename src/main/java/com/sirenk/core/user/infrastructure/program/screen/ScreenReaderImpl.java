package com.sirenk.core.user.infrastructure.program.screen;

import com.sirenk.core.common.exception.EntityNotFoundException;
import com.sirenk.core.user.domain.program.screen.Screen;
import com.sirenk.core.user.domain.program.screen.ScreenReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScreenReaderImpl implements ScreenReader {

    private final ScreenJpaRepository screenJpaRepository;

    @Override
    public Screen read(Long id) {
        return screenJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Screen read(String token) {
        return screenJpaRepository.findByToken(token)
                .orElseThrow(EntityNotFoundException::new);
    }

}
