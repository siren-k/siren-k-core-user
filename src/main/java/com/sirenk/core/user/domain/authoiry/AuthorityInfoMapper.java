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

    AuthorityInfo.AuthorityBasic basic(Authority authority);

    AuthorityInfo.AuthorityRemove remove(Authority authority);

}
