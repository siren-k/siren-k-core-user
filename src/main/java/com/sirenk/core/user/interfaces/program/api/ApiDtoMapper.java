package com.sirenk.core.user.interfaces.program.api;

import com.sirenk.core.user.domain.program.api.ApiCommand;
import com.sirenk.core.user.domain.program.api.ApiInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ApiDtoMapper {

    ApiCommand.Register of(ApiDto.RegisterRequest request);

    ApiCommand.Retrieve of(ApiDto.RetrieveRequest request);

    ApiCommand.ChangeBasicInfo of(ApiDto.ChangeBasicInfoRequest request);

    ApiCommand.Remove of(ApiDto.RemoveRequest request);

    ApiDto.ApiBasicResponse of(ApiInfo.ApiBasic info);

    ApiDto.ApiRemoveResponse of(ApiInfo.ApiRemove info);

}
