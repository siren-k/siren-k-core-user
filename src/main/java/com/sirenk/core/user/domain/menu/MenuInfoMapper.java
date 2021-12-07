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
    MenuInfo.BasicParent of(Menu menu);

    MenuInfo.BasicChildren retrieve(Menu menu);

    @Mapping(target = "parent", ignore = true)
    MenuInfo.BasicParent changeBasicInfo(Menu menu);

    @Mapping(target = "parent", ignore = true)
    MenuInfo.BasicParent move(Menu menu);

    MenuInfo.Remove remove(Menu menu);

}
