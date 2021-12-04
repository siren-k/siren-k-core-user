package com.sirenk.core.user.interfaces.program;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.program.ProgramFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/program")
public class ProgramApiController {

    private final ProgramFacade programFacade;
    private final ProgramDtoMapper programDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<ProgramDto.RegisterResponse> register(@RequestBody @Valid ProgramDto.RegisterRequest request) {
        var command = programDtoMapper.of(request);
        var info = programFacade.register(command);
        var response = programDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "{token}")
    public CommonResponse<ProgramDto.RetrieveResponse> retrieve(@Valid ProgramDto.RetrieveRequest request) {
        var command = programDtoMapper.of(request);
        var info = programFacade.retrieve(command);
        var response = programDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}")
    public CommonResponse<ProgramDto.ChangeBasicInfoResponse> changeBasicInfo(@RequestBody @Valid ProgramDto.ChangeBasicInfoRequest request) {
        var command = programDtoMapper.of(request);
        var info = programFacade.changeBasicInfo(command);
        var response = programDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<ProgramDto.RemoveResponse> remove(@Valid ProgramDto.RemoveRequest request) {
        var command = programDtoMapper.of(request);
        var info = programFacade.remove(command);
        var response = programDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
