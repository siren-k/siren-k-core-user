package com.sirenk.core.user.application.program;

import com.sirenk.core.user.domain.program.api.ApiCommand;
import com.sirenk.core.user.domain.program.ProgramCommand;
import com.sirenk.core.user.domain.program.screen.ScreenCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProgramCommandMapper {

    @Mapping(source = "command.screenToken", target = "token")
    ScreenCommand.Retrieve screen(ProgramCommand.Register command);

    @Mapping(source = "command.screenToken", target = "token")
    ScreenCommand.Retrieve screen(ProgramCommand.ChangeScreen command);

    @Mapping(source = "command.apiToken", target = "token")
    ApiCommand.Retrieve api(ProgramCommand.Register command);

    @Mapping(source = "command.apiToken", target = "token")
    ApiCommand.Retrieve api(ProgramCommand.ChangeApi command);

}
