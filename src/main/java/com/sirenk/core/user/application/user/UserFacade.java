package com.sirenk.core.user.application.user;

import com.sirenk.core.user.domain.user.UserCommand;
import com.sirenk.core.user.domain.user.UserInfo;
import com.sirenk.core.user.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final HttpSession httpSession;

    public UserInfo.UserBasic register(UserCommand.Register command) {
        return userService.register(command);
    }

    public UserInfo.UserBasic retrieve(UserCommand.Retrieve command) {
        return userService.retrieve(command);
    }

    public UserInfo.UserBasic changePassword(UserCommand.ChangePassword command) {
        return userService.changePassword(command);
    }

    public UserInfo.UserBasic login(UserCommand.Login command) {
        return userService.login(command);
    }

    public UserInfo.UserRemove remove(UserCommand.Remove command) {
        return userService.remove(command);
    }

}
