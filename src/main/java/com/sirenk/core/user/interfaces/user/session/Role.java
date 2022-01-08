package com.sirenk.core.user.interfaces.user.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    ENGINEER("엔지니어 역할"),
    ADMIN("관리자 역할"),
    USER("사용자 역할");

    private final String description;

}
