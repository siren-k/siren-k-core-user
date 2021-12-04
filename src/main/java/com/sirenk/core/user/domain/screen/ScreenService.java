package com.sirenk.core.user.domain.screen;

public interface ScreenService {

    ScreenInfo.Basic register(ScreenCommand.Register command);

    ScreenInfo.Retrieve retrieve(ScreenCommand.Retrieve command);

    ScreenInfo.ChangeBasicInfo changeBasicInfo(ScreenCommand.ChangeBasicInfo command);

    ScreenInfo.Remove remove(ScreenCommand.Remove command);

}
