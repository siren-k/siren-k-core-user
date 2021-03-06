package com.sirenk.core.user.domain.user;

public interface UserService {

    UserInfo.UserBasic register(UserCommand.Register command);

    UserInfo.UserBasic retrieve(UserCommand.Retrieve command);

    UserInfo.UserBasic changePassword(UserCommand.ChangePassword command);

    UserInfo.UserRemove remove(UserCommand.Remove command);

}
