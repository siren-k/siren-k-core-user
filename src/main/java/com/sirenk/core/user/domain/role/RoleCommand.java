package com.sirenk.core.user.domain.role;

import com.sirenk.core.user.domain.authoiry.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class RoleCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        private String description;

        public Role toEntity() {
            return Role.builder()
                    .name(name)
                    .description(description)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class Retrieve {
        // 기본 정보
        private String token;
    }

    @Getter
    @Builder
    @ToString
    public static class ChangeBasicInfo {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class AttachAuthority {
        // 기본 정보
        private String token;
        // 권한 정보
        private String authorityToken;
        private Authority authority;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class DetachAuthority {
        // 기본 정보
        private String token;
        // 권한 정보
        private String authorityToken;
        private Authority authority;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }
    
}
