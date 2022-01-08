package com.sirenk.core.user.interfaces.user;

import com.sirenk.core.common.response.CommonResponse;
import com.sirenk.core.user.application.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authentication")
public class AuthenticationApiController {

    private final UserFacade userFacade;
    private final UserDtoMapper userDtoMapper;

    @PutMapping(value = "{email}")
    public CommonResponse<UserDto.UserBasicResponse> login(@RequestBody @Valid UserDto.LoginRequest request,
                                                                    HttpSession httpSession) {
        httpSession.setAttribute(request.getEmail(), request.getEmail());
        httpSession.setAttribute("test@gmail.com", "test@gmail.com");
        String email1 = (String) httpSession.getAttribute(request.getEmail());
        String email2 = (String) httpSession.getAttribute("test@gmail.com");

        var command = userDtoMapper.of(request);
        var info = userFacade.login(command);
        var response = userDtoMapper.of(info);

        return CommonResponse.success(response);
    }

}
