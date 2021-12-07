package com.sirenk.core.user.interfaces.role;

import com.sirenk.core.user.domain.role.RoleCommand;
import com.sirenk.core.user.domain.role.RoleInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface RoleDtoMapper {

    RoleCommand.Register of(RoleDto.RegisterRequest request);

    RoleCommand.Retrieve of(RoleDto.RetrieveRequest request);

    RoleCommand.ChangeBasicInfo of(RoleDto.ChangeBasicInfoRequest request);

    RoleCommand.Remove of(RoleDto.RemoveRequest request);

    RoleDto.BasicResponse of(RoleInfo.Basic info);

    RoleDto.RemoveResponse of(RoleInfo.Remove info);

}
