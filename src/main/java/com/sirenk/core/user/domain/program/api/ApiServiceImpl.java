package com.sirenk.core.user.domain.program.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final ApiStorer apiStorer;
    private final ApiReader apiReader;
    private final ApiInfoMapper apiInfoMapper;

    @Override
    @Transactional
    public ApiInfo.ApiBasic register(ApiCommand.Register command) {
        var initApi = command.toEntity();
        var api = apiStorer.store(initApi);
        return apiInfoMapper.basic(api);
    }

    @Override
    @Transactional(readOnly = true)
    public Api find(ApiCommand.Retrieve command) {
        return apiReader.read(command.getToken());
    }

    @Override
    @Transactional(readOnly = true)
    public ApiInfo.ApiBasic retrieve(ApiCommand.Retrieve command) {
        var api = apiReader.read(command.getToken());
        return apiInfoMapper.basic(api);
    }

    @Override
    @Transactional
    public ApiInfo.ApiBasic changeBasicInfo(ApiCommand.ChangeBasicInfo command) {
        var api = apiReader.read(command.getToken());
        api.changeBasicInfo(
                command.getName(),
                command.getDescription(),
                command.getMethod(),
                command.getUrl(),
                command.isEnable()
        );
        return apiInfoMapper.basic(api);
    }

    @Override
    @Transactional
    public ApiInfo.ApiRemove remove(ApiCommand.Remove command) {
        var api = apiReader.read(command.getToken());
        apiStorer.remove(api);
        return apiInfoMapper.remove(api);
    }

}
