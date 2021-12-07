package com.sirenk.core.user.domain.menu;

import java.util.List;

public interface MenuService {

    MenuInfo.BasicParent register(MenuCommand.Register command);

    Menu find(MenuCommand.Retrieve command);

    List<MenuInfo.BasicChildren> retrieve();

    MenuInfo.BasicParent changeBasicInfo(MenuCommand.ChangeBasicInfo command);

    MenuInfo.BasicParent move(MenuCommand.Move command);

    MenuInfo.Remove remove(MenuCommand.Remove command);

}
