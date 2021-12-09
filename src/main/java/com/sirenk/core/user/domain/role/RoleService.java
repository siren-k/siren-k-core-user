package com.sirenk.core.user.domain.role;

public interface RoleService {

    RoleInfo.RoleBasic register(RoleCommand.Register command);

    RoleInfo.RoleBasic retrieve(RoleCommand.Retrieve command);

    RoleInfo.RoleBasic changeBasicInfo(RoleCommand.ChangeBasicInfo command);

    RoleInfo.RoleRemove remove(RoleCommand.Remove command);

    RoleInfo.RoleBasic attachAuthority(RoleCommand.AttachAuthority command);

    RoleInfo.RoleBasic detachAuthority(RoleCommand.DetachAuthority command);

}
