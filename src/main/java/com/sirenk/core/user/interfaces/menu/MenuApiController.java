package com.sirenk.core.user.interfaces.menu;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.menu.MenuFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu")
public class MenuApiController {

    private final MenuFacade menuFacade;
    private final MenuDtoMapper menuDtoMapper;

    @PostMapping(value = "")
    public CommonResponse<MenuDto.BasicParentResponse> register(@RequestBody @Valid MenuDto.RegisterRequest request) {
        var command = menuDtoMapper.of(request);
        var info = menuFacade.register(command);
        var response = menuDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @GetMapping(value = "")
    public CommonResponse<List<MenuDto.BasicChildrenResponse>> retrieve() {
        var info = menuFacade.retrieve();
        var response = menuDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}")
    public CommonResponse<MenuDto.BasicParentResponse> changeBasicInfo(@RequestBody @Valid MenuDto.ChangeBasicInfoRequest request) {
        var command = menuDtoMapper.of(request);
        var info = menuFacade.changeBasicInfo(command);
        var response = menuDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @PutMapping(value = "{token}/move/{parentToken}")
    public CommonResponse<MenuDto.BasicParentResponse> move(@Valid MenuDto.MoveRequest request) {
        var command = menuDtoMapper.of(request);
        var info = menuFacade.move(command);
        var response = menuDtoMapper.of(info);
        return CommonResponse.success(response);
    }

    @DeleteMapping(value = "{token}")
    public CommonResponse<MenuDto.RemoveResponse> remove(MenuDto.RemoveRequest request) {
        var command = menuDtoMapper.of(request);
        var info = menuFacade.remove(command);
        var response = menuDtoMapper.of(info);
        return CommonResponse.success(response);
    }

}
