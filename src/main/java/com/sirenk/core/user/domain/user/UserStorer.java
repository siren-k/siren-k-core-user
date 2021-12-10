package com.sirenk.core.user.domain.user;

public interface UserStorer {

    User store(User user);

    void remove(User user);

}
