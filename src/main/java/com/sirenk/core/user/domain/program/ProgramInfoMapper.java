package com.sirenk.core.user.domain.program;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProgramInfoMapper {

    ProgramInfo.Register register(Program program);

    ProgramInfo.Retrieve retrieve(Program program);

    ProgramInfo.ChangeBasicInfo changeBasicInfo(Program program);

    ProgramInfo.Remove remove(Program program);

}
