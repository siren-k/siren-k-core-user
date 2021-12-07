package com.sirenk.core.user.domain.screen;

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

    @Override
    @Transactional
    public ScreenInfo.Basic register(ScreenCommand.Register command) {
        var initApi = command.toEntity();
        var screen = screenStorer.store(initApi);
        return screenInfoMapper.basic(screen);
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
        return screenInfoMapper.basic(screen);
    }

    @Override
    @Transactional
    public ScreenInfo.Remove remove(ScreenCommand.Remove command) {
        var screen = screenReader.read(command.getToken());
        screenStorer.remove(screen);
        return screenInfoMapper.remove(screen);
    }

}
