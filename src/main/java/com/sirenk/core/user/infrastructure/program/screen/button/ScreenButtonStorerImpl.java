package com.sirenk.core.user.infrastructure.program.screen.button;

import com.google.common.collect.Lists;
import com.sirenk.core.common.exception.EntityDuplicationException;
import com.sirenk.core.common.exception.EntityNotFoundException;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.user.domain.program.screen.Screen;
import com.sirenk.core.user.domain.program.screen.button.ScreenButton;
import com.sirenk.core.user.domain.program.screen.button.ScreenButtonCommand;
import com.sirenk.core.user.domain.program.screen.button.ScreenButtonStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScreenButtonStorerImpl implements ScreenButtonStorer {

    private final ScreenButtonJpaRepository screenButtonJpaRepository;

    @Override
    public List<ScreenButton> store(Screen screen, List<ScreenButtonCommand.Register> commands) {
        if (commands == null || commands.size() == 0) {
            return Lists.newArrayList();
        }
        return commands.stream()
                .map(command -> {
                    var initScreenButton =
                            command.toBuilder()
                                    .screen(screen)
                                    .build()
                                    .toEntity();
                    store(initScreenButton);
                    return initScreenButton;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ScreenButton> store(List<ScreenButtonCommand.ChangeBasicInfo> commands) {
        List<ScreenButton> screenButtons = Lists.newArrayList();
        for (ScreenButtonCommand.ChangeBasicInfo command : commands) {
            var screenButton =
                    screenButtonJpaRepository.findByToken(command.getToken())
                            .orElseThrow(EntityNotFoundException::new);
            screenButton.changeBasicInfo(command.getName(), command.getDescription(), command.getMethod(), command.getUrl(), command.isEnable());
            store(screenButton);
            screenButtons.add(screenButton);
        }
        return screenButtons;
    }

    @Override
    public ScreenButton store(ScreenButton screenButton) {
        if (screenButton == null) throw new InvalidParamException("screenButton is null");
        if (StringUtils.isEmpty(screenButton.getName())) throw new InvalidParamException("screenButton.getName()");
        if (screenButton.getMethod() == null) throw new InvalidParamException("screenButton.getMethod()");
        if (StringUtils.isEmpty(screenButton.getUrl())) throw new InvalidParamException("screenButton.getUrl()");
        if (screenButton.getScreen() == null) throw new InvalidParamException("screenButton.screen is null");

        try {
            return screenButtonJpaRepository.save(screenButton);
        } catch (DataIntegrityViolationException e) {
            throw new EntityDuplicationException(e.getMessage());
        }
    }

    @Override
    public void remove(ScreenButton button) {
        if (button == null) throw new InvalidParamException("button is null");
        screenButtonJpaRepository.delete(button);
    }

}
