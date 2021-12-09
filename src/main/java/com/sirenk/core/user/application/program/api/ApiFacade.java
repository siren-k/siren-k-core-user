package com.sirenk.core.user.application.program.api;

import com.sirenk.core.user.domain.program.api.ApiCommand;
import com.sirenk.core.user.domain.program.api.ApiInfo;
import com.sirenk.core.user.domain.program.api.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiFacade {

    private final ApiService apiService;

    public ApiInfo.ApiBasic register(ApiCommand.Register command) {
        return apiService.register(command);
    }

    public ApiInfo.ApiBasic retrieve(ApiCommand.Retrieve command) {
        return apiService.retrieve(command);
    }

    public ApiInfo.ApiBasic changeBasicInfo(ApiCommand.ChangeBasicInfo command) {
        return apiService.changeBasicInfo(command);
    }

    public ApiInfo.ApiRemove remove(ApiCommand.Remove command) {
        return apiService.remove(command);
    }

}
