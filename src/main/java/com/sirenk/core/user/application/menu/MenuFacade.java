package com.sirenk.core.user.application.menu;

import com.sirenk.core.user.domain.menu.MenuCommand;
import com.sirenk.core.user.domain.menu.MenuInfo;
import com.sirenk.core.user.domain.menu.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuFacade {

    private final MenuService menuService;

    public MenuInfo.MenuBasicParent register(MenuCommand.Register command) {
        var menu =
                menuService.find(
                        MenuCommand.Retrieve.builder()
                                .token(command.getParentToken())
                                .build());
        var newCommand =
                command.toBuilder()
                        .parent(menu)
                        .build();
        return menuService.register(newCommand);
    }

    public List<MenuInfo.MenuBasicChildren> retrieve() {
        return menuService.retrieve();
    }

    public MenuInfo.MenuBasicParent changeBasicInfo(MenuCommand.ChangeBasicInfo command) {
        return menuService.changeBasicInfo(command);
    }

    public MenuInfo.MenuBasicParent move(MenuCommand.Move command) {
        return menuService.move(command);
    }

    public MenuInfo.MenuRemove remove(MenuCommand.Remove command) {
        return menuService.remove(command);
    }

}
