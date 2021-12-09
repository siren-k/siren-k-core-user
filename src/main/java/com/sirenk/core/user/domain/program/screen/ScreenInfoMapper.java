package com.sirenk.core.user.domain.program.screen;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ScreenInfoMapper {

    ScreenInfo.ScreenBasic basic(Screen screen);

    ScreenInfo.ScreenRemove remove(Screen screen);

}
