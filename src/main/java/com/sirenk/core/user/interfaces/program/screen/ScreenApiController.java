package com.sirenk.core.user.interfaces.program.screen;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.program.screen.ScreenFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/screen")
public class ScreenApiController {

    private final ScreenFacade screenFacade;
    private final ScreenDtoMapper screenDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<ScreenDto.ScreenBasicResponse> register(@RequestBody @Valid ScreenDto.RegisterRequest request) {
        var command = screenDtoMapper.of(request);
        var info = screenFacade.register(command);
        var response = screenDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "{token}")
    public CommonResponse<ScreenDto.ScreenBasicResponse> retrieve(@Valid ScreenDto.RetrieveRequest request) {
        var command = screenDtoMapper.of(request);
        var info = screenFacade.retrieve(command);
        var response = screenDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}")
    public CommonResponse<ScreenDto.ScreenBasicResponse> changeBasicInfo(@RequestBody @Valid ScreenDto.ChangeBasicInfoRequest request) {
        var command = screenDtoMapper.of(request);
        var info = screenFacade.changeBasicInfo(command);
        var response = screenDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}/button")
    public CommonResponse<ScreenDto.ScreenBasicResponse> addScreenButton(@RequestBody @Valid ScreenDto.AddScreenButtonRequest request) {
        var command = screenDtoMapper.of(request);
        var info = screenFacade.addScreenButton(command);
        var response = screenDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<ScreenDto.ScreenRemoveResponse> remove(@Valid ScreenDto.RemoveRequest request) {
        var command = screenDtoMapper.of(request);
        var info = screenFacade.remove(command);
        var response = screenDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
