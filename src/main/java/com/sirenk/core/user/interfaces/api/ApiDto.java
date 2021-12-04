package com.sirenk.core.user.interfaces.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class ApiDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
    }

    @Getter
    @Setter
    @ToString
    public static class RetrieveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    @Getter
    @Builder
    @ToString
    public static class RetrieveResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
    }

}
