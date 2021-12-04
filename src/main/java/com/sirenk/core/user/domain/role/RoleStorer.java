package com.sirenk.core.user.domain.role;

public interface RoleStorer {

    Role store(Role role);

    void remove(Role role);

}
