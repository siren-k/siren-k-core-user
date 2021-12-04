package com.sirenk.core.user.application.authority;

import com.sirenk.core.user.domain.authoiry.AuthorityCommand;
import com.sirenk.core.user.domain.authoiry.AuthorityInfo;
import com.sirenk.core.user.domain.authoiry.AuthorityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorityFacade {

    private final AuthorityService authorityService;

    public AuthorityInfo.Basic register(AuthorityCommand.Register command) {
        return authorityService.register(command);
    }

    public AuthorityInfo.Retrieve retrieve(AuthorityCommand.Retrieve command) {
        return authorityService.retrieve(command);
    }

    public AuthorityInfo.ChangeBasicInfo changeBasicInfo(AuthorityCommand.ChangeBasicInfo command) {
        return authorityService.changeBasicInfo(command);
    }

    public AuthorityInfo.Remove remove(AuthorityCommand.Remove command) {
        return authorityService.remove(command);
    }

}
