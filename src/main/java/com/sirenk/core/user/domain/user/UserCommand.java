package com.sirenk.core.user.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserCommand {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Register {
        // 기본 정보
        private String email;
        private String name;
        // 인증 정보
        private String password;

        public User toEntity() {
            return User.builder()
                    .email(email)
                    .name(name)
                    .password(password)
                    .build();
        }
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Retrieve {
        // 기본 정보
        private String email;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class ChangePassword {
        // 기본 정보
        private String email;
        // 인증 정보
        private String currentPassword;
        private String newPassword;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Login {
        // 기본 정보
        private String email;
        // 인증 정보
        private String password;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Remove {
        // 기본 정보
        private String email;
    }

}
