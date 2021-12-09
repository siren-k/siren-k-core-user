package com.sirenk.core.user.application.authority;

import com.sirenk.core.user.domain.authoiry.AuthorityCommand;
import com.sirenk.core.user.domain.authoiry.AuthorityInfo;
import com.sirenk.core.user.domain.authoiry.AuthorityService;
import com.sirenk.core.user.domain.program.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorityFacade {

    private final AuthorityService authorityService;
    private final AuthorityCommandMapper authorityCommandMapper;
    private final ProgramService programService;

    public AuthorityInfo.AuthorityBasic register(AuthorityCommand.Register command) {
        return authorityService.register(command);
    }

    public AuthorityInfo.AuthorityBasic retrieve(AuthorityCommand.Retrieve command) {
        return authorityService.retrieve(command);
    }

    public AuthorityInfo.AuthorityBasic changeBasicInfo(AuthorityCommand.ChangeBasicInfo command) {
        return authorityService.changeBasicInfo(command);
    }

    public AuthorityInfo.AuthorityRemove remove(AuthorityCommand.Remove command) {
        return authorityService.remove(command);
    }

    @Transactional
    public AuthorityInfo.AuthorityBasic attachProgram(AuthorityCommand.AttachProgram command) {
        var program = programService.find(authorityCommandMapper.program(command));
        var newCommand =
                command.toBuilder().program(program).build();
        return authorityService.attachProgram(newCommand);
    }

    @Transactional
    public AuthorityInfo.AuthorityBasic detachProgram(AuthorityCommand.DetachProgram command) {
        var program = programService.find(authorityCommandMapper.program(command));
        var newCommand =
                command.toBuilder().program(program).build();
        return authorityService.detachProgram(newCommand);
    }

}
