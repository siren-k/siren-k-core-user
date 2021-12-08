package com.sirenk.core.user.application.program;

import com.sirenk.core.user.domain.api.Api;
import com.sirenk.core.user.domain.api.ApiCommand;
import com.sirenk.core.user.domain.api.ApiService;
import com.sirenk.core.user.domain.program.ProgramCommand;
import com.sirenk.core.user.domain.program.ProgramInfo;
import com.sirenk.core.user.domain.program.ProgramService;
import com.sirenk.core.user.domain.program.screen.Screen;
import com.sirenk.core.user.domain.program.screen.ScreenCommand;
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
    private final ApiService apiService;
    private final ProgramCommandMapper programCommandMapper;

    public ProgramInfo.Basic register(ProgramCommand.Register command) {
        var screen = findScreen(programCommandMapper.screen(command));
        var api = findApi(programCommandMapper.api(command));
        var newCommand =
                command.toBuilder().screen(screen).api(api).build();
        return programService.register(newCommand);
    }

    private Screen findScreen(ScreenCommand.Retrieve command) {
        if (command.getToken() == null) {
            return null;
        } else {
            return screenService.find(command);
        }
    }

    private Api findApi(ApiCommand.Retrieve command) {
        if (command.getToken() == null) {
            return null;
        } else {
            return apiService.find(command);
        }
    }

    public ProgramInfo.Basic retrieve(ProgramCommand.Retrieve command) {
        return programService.retrieve(command);
    }

    public ProgramInfo.Basic changeBasicInfo(ProgramCommand.ChangeBasicInfo command) {
        return programService.changeBasicInfo(command);
    }

    public ProgramInfo.Basic changeScreen(ProgramCommand.ChangeScreen command) {
        var screen = screenService.find(programCommandMapper.screen(command));
        var newCommand = command.toBuilder().screen(screen).build();
        return programService.changeScreen(newCommand);
    }

    public ProgramInfo.Basic changeApi(ProgramCommand.ChangeApi command) {
        var api = apiService.find(programCommandMapper.api(command));
        var newCommand = command.toBuilder().api(api).build();
        return programService.changeApi(newCommand);
    }

    public ProgramInfo.Remove remove(ProgramCommand.Remove command) {
        return programService.remove(command);
    }

}
