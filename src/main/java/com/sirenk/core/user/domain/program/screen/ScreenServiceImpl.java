package com.sirenk.core.user.domain.program.screen;

import com.sirenk.core.user.domain.program.screen.button.ScreenButtonInfoMapper;
import com.sirenk.core.user.domain.program.screen.button.ScreenButtonStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenStorer screenStorer;
    private final ScreenReader screenReader;
    private final ScreenInfoMapper screenInfoMapper;
    private final ScreenButtonStorer screenButtonStorer;
    private final ScreenButtonInfoMapper screenButtonInfoMapper;

    @Override
    @Transactional
    public ScreenInfo.Basic register(ScreenCommand.Register command) {
        var initApi = command.toEntity();
        var screen = screenStorer.store(initApi);
        var screenButtons = screenButtonStorer.store(screen, command.getButtons());
        var info = screenInfoMapper.basic(screen);
        return info.toBuilder().buttons(screenButtonInfoMapper.basic(screenButtons)).build();
    }

    @Override
    @Transactional(readOnly = true)
    public Screen find(ScreenCommand.Retrieve command) {
        return screenReader.read(command.getToken());
    }

    @Override
    @Transactional(readOnly = true)
    public ScreenInfo.Basic retrieve(ScreenCommand.Retrieve command) {
        var screen = screenReader.read(command.getToken());
        return screenInfoMapper.basic(screen);
    }

    @Override
    @Transactional
    public ScreenInfo.Basic changeBasicInfo(ScreenCommand.ChangeBasicInfo command) {
        var screen = screenReader.read(command.getToken());
        screen.changeBasicInfo(command.getName(), command.getDescription(), command.isEnable());
        var screenButtons = screenButtonStorer.store(command.getButtons());
        var info = screenInfoMapper.basic(screen);
        return info.toBuilder().buttons(screenButtonInfoMapper.basic(screenButtons)).build();
    }

    @Override
    @Transactional
    public ScreenInfo.Basic addScreenButton(ScreenCommand.AddScreenButton command) {
        var screen = screenReader.read(command.getToken());
        screenButtonStorer.store(screen, command.getButtons());
        var info = screenInfoMapper.basic(screen);
        return info.toBuilder().buttons(screenButtonInfoMapper.basic(screen.getButtons())).build();
    }

    @Override
    @Transactional
    public ScreenInfo.Remove remove(ScreenCommand.Remove command) {
        var screen = screenReader.read(command.getToken());
        screenStorer.remove(screen);
        return screenInfoMapper.remove(screen);
    }

}
