package com.sirenk.core.user.interfaces.api;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.api.ApiFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/api")
public class ApiApiController {

    private final ApiFacade apiFacade;
    private final ApiDtoMapper apiDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<ApiDto.RegisterResponse> register(@RequestBody @Valid ApiDto.RegisterRequest request) {
        var command = apiDtoMapper.of(request);
        var info = apiFacade.register(command);
        var response = apiDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
