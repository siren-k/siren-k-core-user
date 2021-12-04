package com.sirenk.core.user.domain.role;

public interface RoleReader {

    Role read(Long id);

    Role read(String token);

}
