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

    ScreenDto.RegisterResponse of(ScreenInfo.Basic info);

    ScreenCommand.Retrieve of(ScreenDto.RetrieveRequest request);

    ScreenDto.RetrieveResponse of(ScreenInfo.Retrieve info);

    ScreenCommand.ChangeBasicInfo of(ScreenDto.ChangeBasicInfoRequest request);

    ScreenDto.ChangeBasicInfoResponse of(ScreenInfo.ChangeBasicInfo info);

    ScreenCommand.Remove of(ScreenDto.RemoveRequest request);

    ScreenDto.RemoveResponse of(ScreenInfo.Remove info);

}
