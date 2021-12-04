package com.sirenk.core.user.infrastructure.menu;

import com.sirenk.core.common.exception.EntityDuplicationException;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.user.domain.menu.Menu;
import com.sirenk.core.user.domain.menu.MenuStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuStorerImpl implements MenuStorer {

    private final MenuJpaRepository menuJpaRepository;

    @Override
    public Menu store(Menu menu) {
        if (menu == null) throw new InvalidParamException("menu is null");
        if (StringUtils.isEmpty(menu.getToken())) throw new InvalidParamException("menu.getToken");
        if (StringUtils.isEmpty(menu.getName())) throw new InvalidParamException("menu.getName");
        if (StringUtils.isEmpty(menu.getPath())) throw new InvalidParamException("menu.getPath");

        try {
            return menuJpaRepository.save(menu);
        } catch (DataIntegrityViolationException e) {
            throw new EntityDuplicationException(e.getMessage());
        }
    }

    @Override
    public void remove(Menu menu) {
        if (menu == null) throw new InvalidParamException("menu is null");
        menuJpaRepository.delete(menu);
    }

}
