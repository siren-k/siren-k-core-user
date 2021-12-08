package com.sirenk.core.user.infrastructure.screen;

import com.sirenk.core.common.exception.EntityDuplicationException;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.user.domain.program.screen.Screen;
import com.sirenk.core.user.domain.program.screen.ScreenStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScreenStorerImpl implements ScreenStorer {

    private final ScreenJpaRepository screenJpaRepository;

    @Override
    public Screen store(Screen screen) {
        if (screen == null) throw new InvalidParamException("screen is null");
        if (StringUtils.isEmpty(screen.getToken())) throw new InvalidParamException("screen.getToken()");
        if (StringUtils.isEmpty(screen.getName())) throw new InvalidParamException("screen.getName()");

        try {
            return screenJpaRepository.save(screen);
        } catch (DataIntegrityViolationException e) {
            throw new EntityDuplicationException(e.getMessage());
        }
    }

    @Override
    public void remove(Screen screen) {
        if (screen == null) throw new InvalidParamException("screen is null");
        screenJpaRepository.delete(screen);
    }

}
