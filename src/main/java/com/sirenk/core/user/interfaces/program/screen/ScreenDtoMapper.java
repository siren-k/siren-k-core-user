package com.sirenk.core.user.interfaces.program.screen;

import com.sirenk.core.user.domain.program.screen.ScreenCommand;
import com.sirenk.core.user.domain.program.screen.ScreenInfo;
import com.sirenk.core.user.interfaces.program.screen.button.ScreenButtonDtoMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {
                ScreenButtonDtoMapper.class
        }
)
public interface ScreenDtoMapper {

    ScreenCommand.Register of(ScreenDto.RegisterRequest request);

    ScreenCommand.Retrieve of(ScreenDto.RetrieveRequest request);

    ScreenCommand.ChangeBasicInfo of(ScreenDto.ChangeBasicInfoRequest request);

    ScreenCommand.Remove of(ScreenDto.RemoveRequest request);

    ScreenCommand.AddScreenButton of(ScreenDto.AddScreenButtonRequest request);

    ScreenDto.ScreenBasicResponse of(ScreenInfo.ScreenBasic info);

    ScreenDto.ScreenRemoveResponse of(ScreenInfo.ScreenRemove info);

}
