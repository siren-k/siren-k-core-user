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

    ProgramDto.RegisterResponse of(ProgramInfo.Register info);

    ProgramCommand.Retrieve of(ProgramDto.RetrieveRequest request);

    ProgramDto.RetrieveResponse of(ProgramInfo.Retrieve info);

    ProgramCommand.ChangeBasicInfo of(ProgramDto.ChangeBasicInfoRequest request);

    ProgramDto.ChangeBasicInfoResponse of(ProgramInfo.ChangeBasicInfo info);

    ProgramCommand.Remove of(ProgramDto.RemoveRequest request);

    ProgramDto.RemoveResponse of(ProgramInfo.Remove info);

}
