package com.sirenk.core.user.infrastructure.program;

import com.sirenk.core.common.exception.EntityNotFoundException;
import com.sirenk.core.user.domain.program.Program;
import com.sirenk.core.user.domain.program.ProgramReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProgramReaderImpl implements ProgramReader {

    private final ProgramJpaRepository programJpaRepository;

    @Override
    public Program read(Long id) {
        return programJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Program read(String token) {
        return programJpaRepository.findByToken(token)
                .orElseThrow(EntityNotFoundException::new);
    }

}
