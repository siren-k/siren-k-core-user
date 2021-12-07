package com.sirenk.core.user.interfaces.role;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.role.RoleFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/role")
public class RoleApiController {

    private final RoleFacade roleFacade;
    private final RoleDtoMapper roleDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<RoleDto.BasicResponse> register(@RequestBody @Valid RoleDto.RegisterRequest request) {
        var command = roleDtoMapper.of(request);
        var info = roleFacade.register(command);
        var response = roleDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "{token}")
    public CommonResponse<RoleDto.BasicResponse> retrieve(@Valid RoleDto.RetrieveRequest request) {
        var command = roleDtoMapper.of(request);
        var info = roleFacade.retrieve(command);
        var response = roleDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}")
    public CommonResponse<RoleDto.BasicResponse> changeBasicInfo(@RequestBody @Valid RoleDto.ChangeBasicInfoRequest request) {
        var command = roleDtoMapper.of(request);
        var info = roleFacade.changeBasicInfo(command);
        var response = roleDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<RoleDto.RemoveResponse> remove(@Valid RoleDto.RemoveRequest request) {
        var command = roleDtoMapper.of(request);
        var info = roleFacade.remove(command);
        var response = roleDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
