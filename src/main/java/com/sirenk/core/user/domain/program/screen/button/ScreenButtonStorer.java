package com.sirenk.core.user.domain.program.screen.button;

import com.sirenk.core.user.domain.program.screen.Screen;

import java.util.List;

public interface ScreenButtonStorer {

    List<ScreenButton> store(Screen screen, List<ScreenButtonCommand.Register> commands);

    List<ScreenButton> store(List<ScreenButtonCommand.ChangeBasicInfo> commands);

    ScreenButton store(ScreenButton screenButton);

    void remove(ScreenButton screenButton);

}
