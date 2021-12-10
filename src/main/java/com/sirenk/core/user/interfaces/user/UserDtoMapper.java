package com.sirenk.core.user.interfaces.user;

import com.sirenk.core.user.domain.user.UserCommand;
import com.sirenk.core.user.domain.user.UserInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserDtoMapper {

    UserCommand.Register of(UserDto.RegisterRequest request);

    UserCommand.Retrieve of(UserDto.RetrieveRequest request);

    UserCommand.ChangePassword of(UserDto.ChangePasswordRequest request);

    UserCommand.Remove of(UserDto.RemoveRequest request);

    UserDto.UserBasicResponse of(UserInfo.UserBasic info);

    UserDto.UserRemoveResponse of(UserInfo.UserRemove info);

}
