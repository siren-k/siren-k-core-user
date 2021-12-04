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
    DepartmentInfo.Basic of(Department department);

    DepartmentInfo.Hierarchy hierarchy(Department department);

    DepartmentInfo.ChangeBasicInfo changeBasicInfo(Department deparment);

    @Mapping(target = "parent", ignore = true)
    DepartmentInfo.Move move(Department department);

    DepartmentInfo.Remove remove(Department department);

}
