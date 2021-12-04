package com.sirenk.core.user.domain.menu;

import java.util.List;

public interface MenuService {

    MenuInfo.Basic register(MenuCommand.Register command);

    Menu find(MenuCommand.Retrieve command);
    
    List<MenuInfo.Retrieve> retrieve();

    MenuInfo.ChangeBasicInfo changeBasicInfo(MenuCommand.ChangeBasicInfo command);

    MenuInfo.Move move(MenuCommand.Move command);

    MenuInfo.Remove remove(MenuCommand.Remove command);

}
