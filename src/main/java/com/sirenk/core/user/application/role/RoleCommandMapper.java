package com.sirenk.core.user.application.role;

import com.sirenk.core.user.domain.authoiry.AuthorityCommand;
import com.sirenk.core.user.domain.role.RoleCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface RoleCommandMapper {

    @Mapping(source = "command.authorityToken", target = "token")
    AuthorityCommand.Retrieve authority(RoleCommand.AttachAuthority command);

    @Mapping(source = "command.authorityToken", target = "token")
    AuthorityCommand.Retrieve authority(RoleCommand.DetachAuthority command);

}
