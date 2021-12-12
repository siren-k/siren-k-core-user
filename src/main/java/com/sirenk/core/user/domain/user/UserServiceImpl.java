package com.sirenk.core.user.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStorer userStorer;
    private final UserReader userReader;
    private final UserInfoMapper userInfoMapper;

    @Override
    @Transactional
    public UserInfo.UserBasic register(UserCommand.Register command) {
        var initUser = command.toEntity();
        var department = userStorer.store(initUser);
        return userInfoMapper.basic(department);
    }

    @Override
    @Transactional(readOnly = true)
    public UserInfo.UserBasic retrieve(UserCommand.Retrieve command) {
        var user = userReader.read(command.getEmail());
        return userInfoMapper.basic(user);
    }

    @Override
    @Transactional
    public UserInfo.UserBasic changePassword(UserCommand.ChangePassword command) {
        var user = userReader.read(command.getEmail());
        user.changePassword(command.getCurrentPassword(), command.getNewPassword());
        return userInfoMapper.basic(user);
    }

    @Override
    @Transactional
    public UserInfo.UserRemove remove(UserCommand.Remove command) {
        var user = userReader.read(command.getEmail());
        userStorer.remove(user);
        return userInfoMapper.remove(user);
    }

}
