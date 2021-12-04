package com.sirenk.core.user.interfaces.menu;

import com.sirenk.core.user.domain.menu.MenuCommand;
import com.sirenk.core.user.domain.menu.MenuInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MenuDtoMapper {

    @Mapping(target = "parent", ignore = true)
    MenuCommand.Register of(MenuDto.RegisterRequest request);

    @Mapping(source = "info.parent", target = "parent")
    MenuDto.RegisterResponse of(MenuInfo.Basic info);

    List<MenuDto.RetrieveResponse> of(List<MenuInfo.Retrieve> info);

    MenuCommand.ChangeBasicInfo of(MenuDto.ChangeBasicInfoRequest request);

    MenuDto.ChangeBasicInfoResponse of(MenuInfo.ChangeBasicInfo info);

    MenuCommand.Move of(MenuDto.MoveRequest request);

    MenuDto.MoveResponse of(MenuInfo.Move info);

    MenuCommand.Remove of(MenuDto.RemoveRequest request);

    MenuDto.RemoveResponse of(MenuInfo.Remove info);

}
