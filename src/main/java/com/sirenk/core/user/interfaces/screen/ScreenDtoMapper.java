package com.sirenk.core.user.interfaces.screen;

import com.sirenk.core.user.domain.screen.ScreenCommand;
import com.sirenk.core.user.domain.screen.ScreenInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ScreenDtoMapper {

    ScreenCommand.Register of(ScreenDto.RegisterRequest request);

    ScreenCommand.Retrieve of(ScreenDto.RetrieveRequest request);

    ScreenCommand.ChangeBasicInfo of(ScreenDto.ChangeBasicInfoRequest request);

    ScreenCommand.Remove of(ScreenDto.RemoveRequest request);

    ScreenDto.BasicResponse of(ScreenInfo.Basic info);

    ScreenDto.RemoveResponse of(ScreenInfo.Remove info);

}
