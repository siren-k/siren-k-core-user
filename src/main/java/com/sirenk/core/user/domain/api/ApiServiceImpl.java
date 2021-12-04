package com.sirenk.core.user.domain.api;

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
    public ApiInfo.Basic register(ApiCommand.Register command) {
        var initApi = command.toEntity();
        var api = apiStorer.store(initApi);
        return apiInfoMapper.basic(api);
    }

    @Override
    public ApiInfo.Retrieve retrieve(ApiCommand.Retrieve command) {
        var api = apiReader.read(command.getToken());
        return apiInfoMapper.retrieve(api);
    }

}
