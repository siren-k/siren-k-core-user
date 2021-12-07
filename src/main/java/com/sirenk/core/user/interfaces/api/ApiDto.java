package com.sirenk.core.user.interfaces.api;

import com.sirenk.core.user.domain.api.Api;
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
        @NotNull(message = "method: 필수값입니다")
        private Api.Method method;
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
    @Setter
    @ToString
    public static class ChangeBasicInfoRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        @NotNull(message = "name: 필수값입니다")
        private String name;
        @NotNull(message = "method: 필수값입니다")
        private Api.Method method;
        private String description;
        @NotNull(message = "enable: 필수값입니다")
        private boolean enable;
    }

    @Getter
    @Setter
    @ToString
    public static class RemoveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    public record BasicResponse(String token, String name, String description,
                                Api.Method method, boolean enable) {
    }

    public record RemoveResponse(String token) {
    }

}
