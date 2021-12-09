package com.sirenk.core.user.interfaces.authority;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.authority.AuthorityFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authority")
public class AuthorityApiController {

    private final AuthorityFacade authorityFacade;
    private final AuthorityDtoMapper authorityDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<AuthorityDto.AuthorityBasicResponse> register(@RequestBody @Valid AuthorityDto.RegisterRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.register(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "{token}")
    public CommonResponse<AuthorityDto.AuthorityBasicResponse> retrieve(@Valid AuthorityDto.RetrieveRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.retrieve(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}")
    public CommonResponse<AuthorityDto.AuthorityBasicResponse> changeBasicInfo(@RequestBody @Valid AuthorityDto.ChangeBasicInfoRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.changeBasicInfo(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}/program/{programToken}")
    public CommonResponse<AuthorityDto.AuthorityBasicResponse> attachProgram(@Valid AuthorityDto.AttachProgramRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.attachProgram(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}/program/{programToken}")
    public CommonResponse<AuthorityDto.AuthorityBasicResponse> deattachProgram(@Valid AuthorityDto.DetachProgramRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.detachProgram(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<AuthorityDto.AuthorityRemoveResponse> remove(@Valid AuthorityDto.RemoveRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.remove(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
