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
    MenuInfo.Basic of(Menu menu);
    
    MenuInfo.Retrieve retrieve(Menu menu);

    MenuInfo.ChangeBasicInfo changeBasicInfo(Menu menu);

    MenuInfo.Move move(Menu menu);

    MenuInfo.Remove remove(Menu menu);

}
