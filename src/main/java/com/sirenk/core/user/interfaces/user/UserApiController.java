package com.sirenk.core.user.interfaces.user;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserApiController {

    private final UserFacade userFacade;
    private final UserDtoMapper userDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<UserDto.UserBasicResponse> register(@RequestBody @Valid UserDto.RegisterRequest request) {
        var command = userDtoMapper.of(request);
        var info = userFacade.register(command);
        var response = userDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "{token}")
    public CommonResponse<UserDto.UserBasicResponse> retrieve(@Valid UserDto.RetrieveRequest request) {
        var command = userDtoMapper.of(request);
        var info = userFacade.retrieve(command);
        var response = userDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}/password")
    public CommonResponse<UserDto.UserBasicResponse> changePassword(@RequestBody @Valid UserDto.ChangePasswordRequest request) {
        var command = userDtoMapper.of(request);
        var info = userFacade.changePassword(command);
        var response = userDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<UserDto.UserRemoveResponse> remove(@Valid UserDto.RemoveRequest request) {
        var command = userDtoMapper.of(request);
        var info = userFacade.remove(command);
        var response = userDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
