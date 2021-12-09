package com.sirenk.core.user.domain.role;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class RoleInfo {

    @Getter
    @Builder
    @ToString
    public static class RoleBasic {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
    }

    @Getter
    @Builder
    @ToString
    public static class RoleRemove {
        // 기본 정보
        private String token;
    }

}
