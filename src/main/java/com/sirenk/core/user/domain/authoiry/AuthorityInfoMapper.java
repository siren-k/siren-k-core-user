package com.sirenk.core.user.domain.authoiry;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface AuthorityInfoMapper {

    AuthorityInfo.Basic basic(Authority authority);

    AuthorityInfo.Remove remove(Authority authority);

}
