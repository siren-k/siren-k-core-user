package com.sirenk.core.user.application.program;

import com.sirenk.core.user.domain.program.ProgramCommand;
import com.sirenk.core.user.domain.program.ProgramInfo;
import com.sirenk.core.user.domain.program.ProgramService;
import com.sirenk.core.user.domain.program.screen.ScreenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProgramFacade {

    private final ProgramService programService;
    private final ScreenService screenService;
    private final ProgramCommandMapper programCommandMapper;

    public ProgramInfo.Basic register(ProgramCommand.Register command) {
        var screen = screenService.find(programCommandMapper.retrieve(command));
        var newCommand = command.toBuilder().screen(screen).build();
        return programService.register(newCommand);
    }

    public ProgramInfo.Basic retrieve(ProgramCommand.Retrieve command) {
        return programService.retrieve(command);
    }

    public ProgramInfo.Basic changeBasicInfo(ProgramCommand.ChangeBasicInfo command) {
        return programService.changeBasicInfo(command);
    }

    public ProgramInfo.Basic changeScreen(ProgramCommand.ChangeScreen command) {
        var screen = screenService.find(programCommandMapper.retrieve(command));
        var newCommand = command.toBuilder().screen(screen).build();
        return programService.changeScreen(newCommand);
    }

    public ProgramInfo.Remove remove(ProgramCommand.Remove command) {
        return programService.remove(command);
    }

}
