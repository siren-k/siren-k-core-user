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

    AuthorityDto.RegisterResponse of(AuthorityInfo.Basic info);

    AuthorityCommand.Retrieve of(AuthorityDto.RetrieveRequest request);

    AuthorityDto.RetrieveResponse of(AuthorityInfo.Retrieve info);

    AuthorityCommand.ChangeBasicInfo of(AuthorityDto.ChangeBasicInfoRequest request);

    AuthorityDto.ChangeBasicInfoResponse of(AuthorityInfo.ChangeBasicInfo info);

    AuthorityCommand.Remove of(AuthorityDto.RemoveRequest request);

    AuthorityDto.RemoveResponse of(AuthorityInfo.Remove info);

}
