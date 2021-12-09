package com.sirenk.core.user.interfaces.department;

import com.sirenk.core.user.domain.department.DepartmentCommand;
import com.sirenk.core.user.domain.department.DepartmentInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DepartmentDtoMapper {

    @Mapping(target = "parent", ignore = true)
    DepartmentCommand.Register of(DepartmentDto.RegisterRequest request);

    DepartmentCommand.Retrieve of(DepartmentDto.RetrieveRequest request);

    DepartmentCommand.ChangeBasicInfo of(DepartmentDto.ChangeBasicInfoRequest request);

    DepartmentCommand.Move of(DepartmentDto.MoveRequest request);

    DepartmentCommand.Remove of(DepartmentDto.RemoveRequest request);

    @Mapping(source = "info.parent", target = "parent")
    DepartmentDto.DepartmentBasicParentResponse of(DepartmentInfo.DepartmentBasicParent info);

    DepartmentDto.DepartmentBasicChildrenResponse of(DepartmentInfo.DepartmentBasicChildren info);

    DepartmentDto.DepartmentRemoveResponse of(DepartmentInfo.DepartmentRemove info);

}
