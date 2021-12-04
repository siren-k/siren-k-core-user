package com.sirenk.core.user.interfaces.api;

import com.sirenk.core.user.domain.api.ApiCommand;
import com.sirenk.core.user.domain.api.ApiInfo;
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

    ApiDto.RegisterResponse of(ApiInfo.Basic info);

    ApiCommand.Retrieve of(ApiDto.RetrieveRequest request);

    ApiDto.RetrieveResponse of(ApiInfo.Retrieve info);

    ApiCommand.ChangeBasicInfo of(ApiDto.ChangeBasicInfoRequest request);

    ApiDto.ChangeBasicInfoResponse of(ApiInfo.ChangeBasicInfo info);

}
