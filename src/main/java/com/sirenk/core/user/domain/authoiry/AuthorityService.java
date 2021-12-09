package com.sirenk.core.user.domain.authoiry;

public interface AuthorityService {

    AuthorityInfo.AuthorityBasic register(AuthorityCommand.Register command);

    Authority find(AuthorityCommand.Retrieve command);

    AuthorityInfo.AuthorityBasic retrieve(AuthorityCommand.Retrieve command);

    AuthorityInfo.AuthorityBasic changeBasicInfo(AuthorityCommand.ChangeBasicInfo command);

    AuthorityInfo.AuthorityRemove remove(AuthorityCommand.Remove command);

    AuthorityInfo.AuthorityBasic attachProgram(AuthorityCommand.AttachProgram command);

    AuthorityInfo.AuthorityBasic detachProgram(AuthorityCommand.DetachProgram newCommand);

}
