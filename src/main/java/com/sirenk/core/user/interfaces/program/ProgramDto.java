package com.sirenk.core.user.interfaces.program;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class ProgramDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        private final String token;
        private final String name;
        private final String description;
    }

    @Getter
    @Setter
    @ToString
    public static class RetrieveRequest {
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    @Getter
    @Builder
    @ToString
    public static class RetrieveResponse {
        private final String token;
        private final String name;
        private final String description;
    }

    @Getter
    @Setter
    @ToString
    public static class ChangeBasicInfoRequest {
        private String token;
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
    }

    @Getter
    @Builder
    @ToString
    public static class ChangeBasicInfoResponse {
        private final String token;
        private final String name;
        private final String description;
    }

    @Getter
    @Setter
    @ToString
    public static class RemoveRequest {
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    @Getter
    @Builder
    @ToString
    public static class RemoveResponse {
        private final String token;
    }

}
