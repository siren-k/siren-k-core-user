package com.sirenk.core.user.infrastructure.menu;

import com.sirenk.core.common.exception.EntityNotFoundException;
import com.sirenk.core.user.domain.menu.Menu;
import com.sirenk.core.user.domain.menu.MenuReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuReaderImpl implements MenuReader {

    private final MenuJpaRepository menuJpaRepository;
    private final MenuQuerydslRepository menuQuerydslRepository;

    @Override
    public List<Menu> read() {
        return menuJpaRepository.findAllByParentIsNull();
    }

    @Override
    public Menu read(Long id) {
        return menuJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Menu read(String token) {
        return menuJpaRepository.findByToken(token)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Menu readRecursively(String token) {
        return menuQuerydslRepository.findByTokenRecursively(token);
    }

}
