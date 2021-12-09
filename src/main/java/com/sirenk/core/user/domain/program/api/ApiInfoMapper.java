package com.sirenk.core.user.domain.program.api;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ApiInfoMapper {

    ApiInfo.ApiBasic basic(Api api);

    ApiInfo.ApiRemove remove(Api api);

}
