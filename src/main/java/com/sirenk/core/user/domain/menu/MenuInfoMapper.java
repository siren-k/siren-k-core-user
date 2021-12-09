package com.sirenk.core.user.domain.menu;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MenuInfoMapper {

    @Mapping(target = "parent", ignore = true)
    MenuInfo.MenuBasicParent of(Menu menu);

    MenuInfo.MenuBasicChildren retrieve(Menu menu);

    @Mapping(target = "parent", ignore = true)
    MenuInfo.MenuBasicParent changeBasicInfo(Menu menu);

    @Mapping(target = "parent", ignore = true)
    MenuInfo.MenuBasicParent move(Menu menu);

    MenuInfo.MenuRemove remove(Menu menu);

}
