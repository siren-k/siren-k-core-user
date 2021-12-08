package com.sirenk.core.user.domain.program.screen.button;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ScreenButtonInfoMapper {

    List<ScreenButtonInfo.Basic> basic(List<ScreenButton> screenButtons);

    ScreenButtonInfo.Basic basic(ScreenButton screenButton);

}
