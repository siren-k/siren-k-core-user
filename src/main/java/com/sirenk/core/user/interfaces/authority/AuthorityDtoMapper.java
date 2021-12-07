package com.sirenk.core.user.interfaces.authority;

import com.sirenk.core.user.domain.authoiry.AuthorityCommand;
import com.sirenk.core.user.domain.authoiry.AuthorityInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface AuthorityDtoMapper {

    AuthorityCommand.Register of(AuthorityDto.RegisterRequest request);

    AuthorityCommand.Retrieve of(AuthorityDto.RetrieveRequest request);

    AuthorityCommand.ChangeBasicInfo of(AuthorityDto.ChangeBasicInfoRequest request);

    AuthorityCommand.Remove of(AuthorityDto.RemoveRequest request);

    AuthorityDto.BasicResponse of(AuthorityInfo.Basic info);

    AuthorityDto.RemoveResponse of(AuthorityInfo.Remove info);

}
