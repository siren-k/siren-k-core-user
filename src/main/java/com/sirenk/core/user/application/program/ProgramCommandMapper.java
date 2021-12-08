package com.sirenk.core.user.application.program;

import com.sirenk.core.user.domain.program.ProgramCommand;
import com.sirenk.core.user.domain.program.screen.ScreenCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import javax.annotation.MatchesPattern;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProgramCommandMapper {

    @Mapping(source = "command.screenToken", target = "token")
    ScreenCommand.Retrieve retrieve(ProgramCommand.Register command);

    @Mapping(source = "command.screenToken", target = "token")
    ScreenCommand.Retrieve retrieve(ProgramCommand.ChangeScreen command);

}
