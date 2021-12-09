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

    ProgramInfo.ProgramBasic basic(Program program);

    ProgramInfo.ProgramRemove remove(Program program);

}
