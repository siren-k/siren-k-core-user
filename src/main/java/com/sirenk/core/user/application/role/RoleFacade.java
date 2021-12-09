package com.sirenk.core.user.application.role;

import com.sirenk.core.user.domain.role.RoleCommand;
import com.sirenk.core.user.domain.role.RoleInfo;
import com.sirenk.core.user.domain.role.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleFacade {

    private final RoleService roleService;

    public RoleInfo.RoleBasic register(RoleCommand.Register command) {
        return roleService.register(command);
    }

    public RoleInfo.RoleBasic retrieve(RoleCommand.Retrieve command) {
        return roleService.retrieve(command);
    }

    public RoleInfo.RoleBasic changeBasicInfo(RoleCommand.ChangeBasicInfo command) {
        return roleService.changeBasicInfo(command);
    }

    public RoleInfo.RoleRemove remove(RoleCommand.Remove command) {
        return roleService.remove(command);
    }
    
}
