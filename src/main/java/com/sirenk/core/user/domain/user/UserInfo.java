package com.sirenk.core.user.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserInfo {

    @Getter
    @Builder
    @ToString
    public static class UserBasic {
        // 기본 정보
        private String email;
        private String name;
        private boolean enable;
        // 인증 정보
        private String password;
        private boolean locked;
    }

    @Getter
    @Builder
    @ToString
    public static class UserRemove {
        // 기본 정보
        private String email;
    }
    
}
