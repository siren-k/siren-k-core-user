package com.sirenk.core.user.infrastructure.program;

import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.user.domain.program.Program;
import com.sirenk.core.user.domain.program.ProgramStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProgramStorerImpl implements ProgramStorer {

    private final ProgramJpaRepository programJpaRepository;

    @Override
    public Program store(Program program) {
        if (StringUtils.isEmpty(program.getToken())) throw new InvalidParamException("program.getToken()");
        if (StringUtils.isEmpty(program.getName())) throw new InvalidParamException("program.getName()");
        return programJpaRepository.save(program);
    }

    @Override
    public void remove(Program program) {
        if (program == null) throw new InvalidParamException("program is null");
        programJpaRepository.delete(program);
    }

}
