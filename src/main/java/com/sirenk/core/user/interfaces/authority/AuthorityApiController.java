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
    public CommonResponse<AuthorityDto.RegisterResponse> register(@RequestBody @Valid AuthorityDto.RegisterRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.register(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "{token}")
    public CommonResponse<AuthorityDto.RetrieveResponse> retrieve(@Valid AuthorityDto.RetrieveRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.retrieve(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}")
    public CommonResponse<AuthorityDto.ChangeBasicInfoResponse> changeBasicInfo(@RequestBody @Valid AuthorityDto.ChangeBasicInfoRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.changeBasicInfo(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<AuthorityDto.RemoveResponse> remove(@Valid AuthorityDto.RemoveRequest request) {
        var command = authorityDtoMapper.of(request);
        var info = authorityFacade.remove(command);
        var response = authorityDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
