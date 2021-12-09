package com.sirenk.core.user.interfaces.program.api;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.program.api.ApiFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/api")
public class ApiApiController {

    private final ApiFacade apiFacade;
    private final ApiDtoMapper apiDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<ApiDto.ApiBasicResponse> register(@RequestBody @Valid ApiDto.RegisterRequest request) {
        var command = apiDtoMapper.of(request);
        var info = apiFacade.register(command);
        var response = apiDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "{token}")
    public CommonResponse<ApiDto.ApiBasicResponse> retrieve(@Valid ApiDto.RetrieveRequest request) {
        var command = apiDtoMapper.of(request);
        var info = apiFacade.retrieve(command);
        var response = apiDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}")
    public CommonResponse<ApiDto.ApiBasicResponse> changeBasicInfo(@RequestBody @Valid ApiDto.ChangeBasicInfoRequest request) {
        var command = apiDtoMapper.of(request);
        var info = apiFacade.changeBasicInfo(command);
        var response = apiDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<ApiDto.ApiRemoveResponse> remove(@Valid ApiDto.RemoveRequest request) {
        var command = apiDtoMapper.of(request);
        var info = apiFacade.remove(command);
        var response = apiDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
