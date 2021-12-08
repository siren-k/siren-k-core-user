package com.sirenk.core.user.interfaces.program;

import com.sirenk.core.user.domain.program.ProgramCommand;
import com.sirenk.core.user.domain.program.ProgramInfo;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProgramDtoMapper {

    @Mappings({
            @Mapping(target = "screen", ignore = true),
            @Mapping(target = "api", ignore = true)
    })
    ProgramCommand.Register of(ProgramDto.RegisterRequest request);

    ProgramCommand.Retrieve of(ProgramDto.RetrieveRequest request);

    ProgramCommand.ChangeBasicInfo of(ProgramDto.ChangeBasicInfoRequest request);

    @Mapping(target = "screen", ignore = true)
    ProgramCommand.ChangeScreen of(ProgramDto.ChangeScreenRequest request);

    @Mapping(target = "api", ignore = true)
    ProgramCommand.ChangeApi of(ProgramDto.ChangeApiRequest request);

    ProgramCommand.Remove of(ProgramDto.RemoveRequest request);

//    @Mappings({
//            @Mapping(source = "info.screen", target = "screen"),
//            @Mapping(source = "info.screen.buttons", target = "screen.buttons")
//    })
    ProgramDto.BasicResponse of(ProgramInfo.Basic info);

    ProgramDto.RemoveResponse of(ProgramInfo.Remove info);

}
