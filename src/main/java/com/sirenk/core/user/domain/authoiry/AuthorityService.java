package com.sirenk.core.user.domain.authoiry;

public interface AuthorityService {

    AuthorityInfo.Basic register(AuthorityCommand.Register command);

    Authority find(AuthorityCommand.Retrieve command);

    AuthorityInfo.Basic retrieve(AuthorityCommand.Retrieve command);

    AuthorityInfo.Basic changeBasicInfo(AuthorityCommand.ChangeBasicInfo command);

    AuthorityInfo.Remove remove(AuthorityCommand.Remove command);

}
