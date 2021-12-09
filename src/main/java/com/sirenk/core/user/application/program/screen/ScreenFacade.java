package com.sirenk.core.user.application.program.screen;

import com.sirenk.core.user.domain.program.screen.ScreenCommand;
import com.sirenk.core.user.domain.program.screen.ScreenInfo;
import com.sirenk.core.user.domain.program.screen.ScreenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScreenFacade {

    private final ScreenService screenService;

    public ScreenInfo.ScreenBasic register(ScreenCommand.Register command) {
        return screenService.register(command);
    }

    public ScreenInfo.ScreenBasic retrieve(ScreenCommand.Retrieve command) {
        return screenService.retrieve(command);
    }

    public ScreenInfo.ScreenBasic changeBasicInfo(ScreenCommand.ChangeBasicInfo command) {
        return screenService.changeBasicInfo(command);
    }

    public ScreenInfo.ScreenBasic addScreenButton(ScreenCommand.AddScreenButton command) {
        return screenService.addScreenButton(command);
    }

    public ScreenInfo.ScreenRemove remove(ScreenCommand.Remove command) {
        return screenService.remove(command);
    }

}
