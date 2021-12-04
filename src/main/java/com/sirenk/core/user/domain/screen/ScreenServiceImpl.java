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
        var api = screenStorer.store(initApi);
        return screenInfoMapper.basic(api);
    }

    @Override
    @Transactional(readOnly = true)
    public ScreenInfo.Retrieve retrieve(ScreenCommand.Retrieve command) {
        var api = screenReader.read(command.getToken());
        return screenInfoMapper.retrieve(api);
    }

    @Override
    @Transactional
    public ScreenInfo.ChangeBasicInfo changeBasicInfo(ScreenCommand.ChangeBasicInfo command) {
        var api = screenReader.read(command.getToken());
        api.changeBasicInfo(command.getName(), command.getDescription());
        return screenInfoMapper.changeBasicInfo(api);
    }

    @Override
    @Transactional
    public ScreenInfo.Remove remove(ScreenCommand.Remove command) {
        var api = screenReader.read(command.getToken());
        screenStorer.remove(api);
        return screenInfoMapper.remove(api);
    }

}
