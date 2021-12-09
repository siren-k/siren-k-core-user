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

    RoleInfo.RoleBasic basic(Role role);

    RoleInfo.RoleRemove remove(Role role);

}
