package com.sirenk.core.user.domain.menu;

import java.util.List;

public interface MenuService {

    MenuInfo.MenuBasicParent register(MenuCommand.Register command);

    Menu find(MenuCommand.Retrieve command);

    List<MenuInfo.MenuBasicChildren> retrieve();

    MenuInfo.MenuBasicParent changeBasicInfo(MenuCommand.ChangeBasicInfo command);

    MenuInfo.MenuBasicParent move(MenuCommand.Move command);

    MenuInfo.MenuRemove remove(MenuCommand.Remove command);

}
