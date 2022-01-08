package com.sirenk.core.user.domain.user;

import com.sirenk.core.common.exception.AuthenticationException;
import com.sirenk.core.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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
    public UserInfo.UserBasic login(UserCommand.Login command) {
        User user;
        try {
            user = userReader.read(command.getEmail());
        } catch (EntityNotFoundException e) {
            throw new AuthenticationException(ErrorCode.AUTHENTICATION_ERROR.getErrorMsg("사용자가 존재하지 않습니다"));
        }
        if (!user.getPassword().equals(command.getPassword())) {
            throw new AuthenticationException(ErrorCode.AUTHENTICATION_ERROR.getErrorMsg("패스워드가 일치히지 않습니다"));
        }

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
