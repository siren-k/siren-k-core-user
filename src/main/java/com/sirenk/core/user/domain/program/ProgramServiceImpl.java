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
    public ProgramInfo.ProgramBasic register(ProgramCommand.Register command) {
        var initProgram = command.toEntity();
        var program = programStorer.store(initProgram);
        return programInfoMapper.basic(program);
    }

    @Override
    public Program find(ProgramCommand.Retrieve command) {
        return programReader.read(command.getToken());
    }

    @Override
    @Transactional(readOnly = true)
    public ProgramInfo.ProgramBasic retrieve(ProgramCommand.Retrieve command) {
        var program = programReader.read(command.getToken());
        return programInfoMapper.basic(program);
    }

    @Override
    @Transactional
    public ProgramInfo.ProgramBasic changeBasicInfo(ProgramCommand.ChangeBasicInfo command) {
        var program = programReader.read(command.getToken());
        program.changeBasicInfo(command.getName(), command.getDescription(), command.isEnable());
        return programInfoMapper.basic(program);
    }

    @Override
    @Transactional
    public ProgramInfo.ProgramBasic changeScreen(ProgramCommand.ChangeScreen command) {
        var program = programReader.read(command.getToken());
        program.changeScreen(command.getScreen());
        return programInfoMapper.basic(program);
    }

    @Override
    @Transactional
    public ProgramInfo.ProgramBasic changeApi(ProgramCommand.ChangeApi command) {
        var program = programReader.read(command.getToken());
        program.changeApi(command.getApi());
        return programInfoMapper.basic(program);
    }

    @Override
    @Transactional
    public ProgramInfo.ProgramRemove remove(ProgramCommand.Remove command) {
        var program = programReader.read(command.getToken());
        programStorer.remove(program);
        return programInfoMapper.remove(program);
    }

}
