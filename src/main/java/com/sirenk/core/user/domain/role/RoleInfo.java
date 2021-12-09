package com.sirenk.core.user.domain.role;

import com.sirenk.core.user.domain.authoiry.AuthorityInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

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
        // 권한 정보
        private List<AuthorityInfo.AuthorityBasic> authorities;
    }

    @Getter
    @Builder
    @ToString
    public static class RoleRemove {
        // 기본 정보
        private String token;
    }

}
