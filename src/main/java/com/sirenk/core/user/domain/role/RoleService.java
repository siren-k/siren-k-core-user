package com.sirenk.core.user.domain.role;

public interface RoleService {

    RoleInfo.Basic register(RoleCommand.Register command);

    RoleInfo.Basic retrieve(RoleCommand.Retrieve command);

    RoleInfo.Basic changeBasicInfo(RoleCommand.ChangeBasicInfo command);

    RoleInfo.Remove remove(RoleCommand.Remove command);

}
