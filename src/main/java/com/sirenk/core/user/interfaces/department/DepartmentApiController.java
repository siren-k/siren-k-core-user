package com.sirenk.core.user.interfaces.department;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.department.DepartmentFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")
public class DepartmentApiController {

    private final DepartmentFacade departmentFacade;
    private final DepartmentDtoMapper departmentDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<DepartmentDto.RegisterResponse> register(@RequestBody @Valid DepartmentDto.RegisterRequest request) {
        var command = departmentDtoMapper.of(request);
        var info = departmentFacade.register(command);
        var response = departmentDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "{token}")
    public CommonResponse<DepartmentDto.RetrieveResponse> retrieve(@Valid DepartmentDto.RetrieveRequest request) {
        var command = departmentDtoMapper.of(request);
        var info = departmentFacade.retrieve(command);
        var response = departmentDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}")
    public CommonResponse<DepartmentDto.ChangeBasicInfoResponse> changeBasicInfo(@RequestBody @Valid DepartmentDto.ChangeBasicInfoRequest request) {
        var command = departmentDtoMapper.of(request);
        var info = departmentFacade.changeBasicInfo(command);
        var response = departmentDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}/move/{parentToken}")
    public CommonResponse<DepartmentDto.MoveResponse> move(@Valid DepartmentDto.MoveRequest request) {
        var command = departmentDtoMapper.of(request);
        var info = departmentFacade.move(command);
        var response = departmentDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<DepartmentDto.RemoveResponse> remove(@Valid DepartmentDto.RemoveRequest request) {
        var command = departmentDtoMapper.of(request);
        var info = departmentFacade.remove(command);
        var response = departmentDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
