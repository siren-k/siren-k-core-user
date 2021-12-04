package com.sirenk.core.user.application.api;

import com.sirenk.core.user.domain.api.ApiCommand;
import com.sirenk.core.user.domain.api.ApiInfo;
import com.sirenk.core.user.domain.api.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiFacade {

    private final ApiService apiService;

    public ApiInfo.Basic register(ApiCommand.Register command) {
        return apiService.register(command);
    }

    public ApiInfo.Retrieve retrieve(ApiCommand.Retrieve command) {
        return apiService.retrieve(command);
    }

    public ApiInfo.ChangeBasicInfo changeBasicInfo(ApiCommand.ChangeBasicInfo command) {
        return apiService.changeBasicInfo(command);
    }

    public ApiInfo.Remove remove(ApiCommand.Remove command) {
        return apiService.remove(command);
    }

}
