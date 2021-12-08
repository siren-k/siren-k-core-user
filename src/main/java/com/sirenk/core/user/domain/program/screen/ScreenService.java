package com.sirenk.core.user.domain.program.screen;

public interface ScreenService {

    ScreenInfo.Basic register(ScreenCommand.Register command);

    Screen find(ScreenCommand.Retrieve command);

    ScreenInfo.Basic retrieve(ScreenCommand.Retrieve command);

    ScreenInfo.Basic changeBasicInfo(ScreenCommand.ChangeBasicInfo command);

    ScreenInfo.Remove remove(ScreenCommand.Remove command);

}
