package com.sirenk.core.user.application.screen;

import com.sirenk.core.user.domain.screen.ScreenCommand;
import com.sirenk.core.user.domain.screen.ScreenInfo;
import com.sirenk.core.user.domain.screen.ScreenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScreenFacade {

    private final ScreenService screenService;

    public ScreenInfo.Basic register(ScreenCommand.Register command) {
        return screenService.register(command);
    }

    public ScreenInfo.Retrieve retrieve(ScreenCommand.Retrieve command) {
        return screenService.retrieve(command);
    }

    public ScreenInfo.ChangeBasicInfo changeBasicInfo(ScreenCommand.ChangeBasicInfo command) {
        return screenService.changeBasicInfo(command);
    }

    public ScreenInfo.Remove remove(ScreenCommand.Remove command) {
        return screenService.remove(command);
    }

}
