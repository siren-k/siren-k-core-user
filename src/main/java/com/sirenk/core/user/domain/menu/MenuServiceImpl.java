package com.sirenk.core.user.domain.menu;

import com.sirenk.core.common.exception.EntityHasChildrenException;
import com.sirenk.core.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuStorer menuStorer;
    private final MenuReader menuReader;
    private final MenuInfoMapper menuInfoMapper;

    @Override
    @Transactional
    public MenuInfo.BasicParent register(MenuCommand.Register command) {
        var initMenu = command.toEntity();
        var menu = menuStorer.store(initMenu);
        var info = menuInfoMapper.of(menu);
        return info.toBuilder().parent(menuInfoMapper.of(menu.getParent())).build();
    }

    @Override
    @Transactional(readOnly = true)
    public Menu find(MenuCommand.Retrieve command) {
        if (StringUtils.isEmpty(command.getToken())) return null;
        return menuReader.read(command.getToken());
    }
  
    @Override
    @Transactional(readOnly = true)
    public List<MenuInfo.BasicChildren> retrieve() {
        List<MenuInfo.BasicChildren> infos = new ArrayList<>();
        var menus = menuReader.read();
        for (Menu menu : menus) {
            var info = menuInfoMapper.retrieve(menu);
            infos.add(info);
        }
        return infos;
    }

    @Override
    @Transactional
    public MenuInfo.BasicParent changeBasicInfo(MenuCommand.ChangeBasicInfo command) {
        var menu = menuReader.read(command.getToken());
        menu.changeBasicInfo(command.getName(), command.getDescription(), command.isEnable());
        return menuInfoMapper.changeBasicInfo(menu);
    }

    @Override
    @Transactional
    public MenuInfo.BasicParent move(MenuCommand.Move command) {
        var menu = menuReader.read(command.getToken());
        var parentMenu= menuReader.read(command.getParentToken());
        menu.changeParent(parentMenu);
        menu.renewPath();

        var info = menuInfoMapper.move(menu);
        return info.toBuilder().parent(menuInfoMapper.move(menu.getParent())).build();
    }

    @Override
    @Transactional
    public MenuInfo.Remove remove(MenuCommand.Remove command) {
        var menu = menuReader.read(command.getToken());
        if (menu.getChildren().size() > 0) {
            throw new EntityHasChildrenException(ErrorCode.ENTITY_HAS_CHILDREN.getErrorMsg(menu.getName(), menu.getChildren().size()));
        }
        menuStorer.remove(menu);
        return menuInfoMapper.remove(menu);
    }

}
