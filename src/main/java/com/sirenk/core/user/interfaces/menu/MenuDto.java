package com.sirenk.core.user.interfaces.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MenuDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
        // 상위 메뉴 정보
        private String parentToken;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
        // 상위 메뉴 정보
        private final String path;
        private final RegisterResponse parent;
    }

    @Getter
    @Builder
    @ToString
    public static class RetrieveResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
        // 하위 메뉴 정보
        private final String path;
        private List<RetrieveResponse> children;
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
        private String description;
    }

    @Getter
    @Builder
    @ToString
    public static class ChangeBasicInfoResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
    }

    @Getter
    @Setter
    @ToString
    public static class RemoveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    @Getter
    @Setter
    @ToString
    public static class MoveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // 상위 메뉴 정보
        @NotNull(message = "parentToken: 필수값입니다")
        private String parentToken;
    }

    @Getter
    @Builder
    @ToString
    public static class MoveResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
        // 상위 메뉴 정보
        private final String path;
        private final MoveResponse parent;
    }

    @Getter
    @Builder
    @ToString
    public static class RemoveResponse {
        // 기본 정보
        private final String token;
    }

}
