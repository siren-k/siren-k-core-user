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
    DepartmentInfo.DepartmentBasicParent of(Department department);

    DepartmentInfo.DepartmentBasicChildren retrieve(Department department);

    @Mapping(target = "parent", ignore = true)
    DepartmentInfo.DepartmentBasicParent changeBasicInfo(Department department);

    @Mapping(target = "parent", ignore = true)
    DepartmentInfo.DepartmentBasicParent move(Department department);

    DepartmentInfo.DepartmentRemove remove(Department department);

}
