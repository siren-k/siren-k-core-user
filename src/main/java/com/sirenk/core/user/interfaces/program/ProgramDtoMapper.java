package com.sirenk.core.user.interfaces.program;

import com.sirenk.core.user.domain.program.ProgramCommand;
import com.sirenk.core.user.domain.program.ProgramInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProgramDtoMapper {

    ProgramCommand.Register of(ProgramDto.RegisterRequest request);

    ProgramCommand.Retrieve of(ProgramDto.RetrieveRequest request);

    ProgramCommand.ChangeBasicInfo of(ProgramDto.ChangeBasicInfoRequest request);

    ProgramCommand.Remove of(ProgramDto.RemoveRequest request);

    ProgramDto.BasicResponse of(ProgramInfo.Basic info);

    ProgramDto.RemoveResponse of(ProgramInfo.Remove info);

}
