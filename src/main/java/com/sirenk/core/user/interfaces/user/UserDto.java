package com.sirenk.core.user.interfaces.user;

import com.sirenk.core.user.interfaces.user.session.UserSession;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class UserDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "email: 필수값입니다")
        private String email;
        @NotNull(message = "name: 필수값입니다")
        private String name;
        // 인증 정보
        @NotNull(message = "password: 필수값입니다")
        private String password;
    }

    @Getter
    @Setter
    @ToString
    public static class RetrieveRequest {
        // 기본 정보
        @NotNull(message = "email: 필수값입니다")
        private String email;
    }

    @Getter
    @Setter
    @ToString
    public static class ChangePasswordRequest {
        // 기본 정보
        @NotNull(message = "email: 필수값입니다")
        private String email;
        // 인증 정보
        @NotNull(message = "currentPassword: 필수값입니다")
        private String currentPassword;
        @NotNull(message = "newPassword: 필수값입니다")
        private String newPassword;
    }

    @Getter
    @Setter
    @ToString
    public static class LoginRequest {
        // 기본 정보
        @NotNull(message = "email: 필수값입니다")
        private String email;
        @NotNull(message = "password: 필수값입니다")
        private String password;
    }


    @Getter
    @Setter
    @ToString
    public static class RemoveRequest {
        // 기본 정보
        @NotNull(message = "email: 필수값입니다")
        private String email;
    }

    @Getter
    @Builder
    @ToString
    public static class UserBasicResponse {
        // 기본 정보
        private final String email;
        private final String name;
        private final boolean enable;
        // 인증 정보
        private final String password;
        private final boolean locked;
    }

    @Getter
    @Builder
    @ToString
    public static class UserRemoveResponse {
        // 기본 정보
        private final String email;
    }

}
