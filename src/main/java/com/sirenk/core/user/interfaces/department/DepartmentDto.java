package com.sirenk.core.user.interfaces.department;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DepartmentDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "name: 필수값입니다")
        private String name;
        // 상위 부서 정보
        private String parentToken;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String path;
        private final int order;
        // 상위 부서 정보
        private final RegisterResponse parent;
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
        private final String path;
        private final int order;
        // 하위 부서 정보
        private final List<RetrieveResponse> children;
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
    }

    @Getter
    @Builder
    @ToString
    public static class ChangeBasicInfoResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String path;
    }

    @Getter
    @Setter
    @ToString
    public static class MoveRequest {
        @NotNull(message = "token: 필수값입니다")
        private String token;
        @NotNull(message = "parentToken: 필수값입니다")
        private String parentToken;
    }

    @Getter
    @Builder
    @ToString
    public static class MoveResponse {
        private final String token;
        private final String name;
        private final String path;
        private final int order;
        private final MoveResponse parent;
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
