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

    MenuCommand.ChangeBasicInfo of(MenuDto.ChangeBasicInfoRequest request);

    MenuCommand.Move of(MenuDto.MoveRequest request);

    MenuCommand.Remove of(MenuDto.RemoveRequest request);

    @Mapping(source = "info.parent", target = "parent")
    MenuDto.BasicParentResponse of(MenuInfo.BasicParent info);

    List<MenuDto.BasicChildrenResponse> of(List<MenuInfo.BasicChildren> info);

    MenuDto.BasicChildrenResponse of(MenuInfo.BasicChildren info);

    MenuDto.RemoveResponse of(MenuInfo.Remove info);

}
