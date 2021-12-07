package com.sirenk.core.user.domain.screen;

public interface ScreenService {

    ScreenInfo.Basic register(ScreenCommand.Register command);

    ScreenInfo.Basic retrieve(ScreenCommand.Retrieve command);

    ScreenInfo.Basic changeBasicInfo(ScreenCommand.ChangeBasicInfo command);

    ScreenInfo.Remove remove(ScreenCommand.Remove command);

}
