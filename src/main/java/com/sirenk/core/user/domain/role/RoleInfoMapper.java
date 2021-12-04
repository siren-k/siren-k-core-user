package com.sirenk.core.user.domain.role;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface RoleInfoMapper {

    RoleInfo.Register register(Role role);

    RoleInfo.Retrieve retrieve(Role role);

    RoleInfo.ChangeBasicInfo changeBasicInfo(Role role);

    RoleInfo.Remove remove(Role role);

}
