package com.sirenk.core.user.domain.program.screen;

public interface ScreenService {

    ScreenInfo.ScreenBasic register(ScreenCommand.Register command);

    Screen find(ScreenCommand.Retrieve command);

    ScreenInfo.ScreenBasic retrieve(ScreenCommand.Retrieve command);

    ScreenInfo.ScreenBasic changeBasicInfo(ScreenCommand.ChangeBasicInfo command);

    ScreenInfo.ScreenBasic addScreenButton(ScreenCommand.AddScreenButton command);

    ScreenInfo.ScreenRemove remove(ScreenCommand.Remove command);

}
