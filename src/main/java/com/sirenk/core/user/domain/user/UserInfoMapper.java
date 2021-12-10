package com.sirenk.core.user.domain.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserInfoMapper {

    UserInfo.UserBasic basic(User user);

    UserInfo.UserRemove remove(User user);

}
