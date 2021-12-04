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

    @Mapping(source = "info.parent", target = "parent")
    DepartmentDto.RegisterResponse of(DepartmentInfo.Basic info);

    DepartmentCommand.Retrieve of(DepartmentDto.RetrieveRequest request);

    DepartmentDto.RetrieveResponse of(DepartmentInfo.Hierarchy info);

    DepartmentCommand.ChangeBasicInfo of(DepartmentDto.ChangeBasicInfoRequest request);

    DepartmentDto.ChangeBasicInfoResponse of(DepartmentInfo.ChangeBasicInfo info);

    DepartmentCommand.Move of(DepartmentDto.MoveRequest request);

    DepartmentDto.MoveResponse of(DepartmentInfo.Move info);

    DepartmentCommand.Remove of(DepartmentDto.RemoveRequest request);

    DepartmentDto.RemoveResponse of(DepartmentInfo.Remove info);

}
