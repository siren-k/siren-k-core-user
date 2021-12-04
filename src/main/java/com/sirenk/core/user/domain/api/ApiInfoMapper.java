package com.sirenk.core.user.domain.api;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ApiInfoMapper {

    ApiInfo.Basic basic(Api api);

    ApiInfo.Retrieve retrieve(Api api);

}
