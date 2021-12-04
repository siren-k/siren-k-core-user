package com.sirenk.core.user.domain.role;

public interface RoleService {

    RoleInfo.Register register(RoleCommand.Register command);

    RoleInfo.Retrieve retrieve(RoleCommand.Retrieve command);

    RoleInfo.ChangeBasicInfo changeBasicInfo(RoleCommand.ChangeBasicInfo command);

    RoleInfo.Remove remove(RoleCommand.Remove command);

}
