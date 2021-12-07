package com.sirenk.core.user.domain.screen;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ScreenInfoMapper {

    ScreenInfo.Basic basic(Screen screen);

    ScreenInfo.Remove remove(Screen screen);

}
