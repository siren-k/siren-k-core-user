package com.sirenk.core.user.domain.department;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DepartmentInfoMapper {

    @Mapping(target = "parent", ignore = true)
    DepartmentInfo.BasicParent of(Department department);

    DepartmentInfo.BasicChildren retrieve(Department department);

    @Mapping(target = "parent", ignore = true)
    DepartmentInfo.BasicParent changeBasicInfo(Department department);

    @Mapping(target = "parent", ignore = true)
    DepartmentInfo.BasicParent move(Department department);

    DepartmentInfo.Remove remove(Department department);

}
