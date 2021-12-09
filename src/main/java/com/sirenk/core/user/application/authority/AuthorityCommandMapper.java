package com.sirenk.core.user.application.authority;

import com.sirenk.core.user.domain.authoiry.AuthorityCommand;
import com.sirenk.core.user.domain.program.ProgramCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface AuthorityCommandMapper {

    @Mapping(source = "command.programToken", target = "token")
    ProgramCommand.Retrieve program(AuthorityCommand.AttachProgram command);

    @Mapping(source = "command.programToken", target = "token")
    ProgramCommand.Retrieve program(AuthorityCommand.DetachProgram command);

}
