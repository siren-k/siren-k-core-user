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

}