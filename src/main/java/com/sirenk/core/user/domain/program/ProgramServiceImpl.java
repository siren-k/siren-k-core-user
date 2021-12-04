package com.sirenk.core.user.domain.program;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramStorer programStorer;
    private final ProgramReader programReader;
    private final ProgramInfoMapper programInfoMapper;

    @Override
    @Transactional
    public ProgramInfo.Register register(ProgramCommand.Register command) {
        var initProgram = command.toEntity();
        var program = programStorer.store(initProgram);
        return programInfoMapper.register(program);
    }

    @Override
    @Transactional(readOnly = true)
    public ProgramInfo.Retrieve retrieve(ProgramCommand.Retrieve command) {
        var program = programReader.read(command.getToken());
        return programInfoMapper.retrieve(program);
    }

    @Override
    @Transactional
    public ProgramInfo.ChangeBasicInfo changeBasicInfo(ProgramCommand.ChangeBasicInfo command) {
        var program = programReader.read(command.getToken());
        program.changeBasicInfo(command.getName(), command.getDescription());
        return programInfoMapper.changeBasicInfo(program);
    }

    @Override
    @Transactional
    public ProgramInfo.Remove remove(ProgramCommand.Remove command) {
        var program = programReader.read(command.getToken());
        programStorer.remove(program);
        return programInfoMapper.remove(program);
    }

}
