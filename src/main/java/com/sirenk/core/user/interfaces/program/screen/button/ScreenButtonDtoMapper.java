package com.sirenk.core.user.interfaces.program.screen.button;

import com.sirenk.core.user.domain.program.screen.button.ScreenButtonCommand;
import com.sirenk.core.user.domain.program.screen.button.ScreenButtonInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ScreenButtonDtoMapper {

    @Mapping(target = "screen", ignore = true)
    ScreenButtonCommand.Register of(ScreenButtonDto.RegisterRequest request);

    @Mapping(target = "screen", ignore = true)
    ScreenButtonCommand.ChangeBasicInfo of(ScreenButtonDto.ChangeBasicInfoRequest request);

    ScreenButtonDto.BasicResponse of(ScreenButtonInfo.Basic info);

}
