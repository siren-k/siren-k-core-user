package com.sirenk.core.user.domain.user;

public interface UserReader {

    User read(Long id);

    User read(String email);

}
