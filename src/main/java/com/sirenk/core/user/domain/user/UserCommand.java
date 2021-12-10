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
        private String name;
        // 인증 정보
        private String password;
        // 개인 정보
        private String email;

        public User toEntity() {
            return User.builder()
                    .name(name)
                    .password(password)
                    .email(email)
                    .build();
        }
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Retrieve {
        // 기본 정보
        private String token;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
