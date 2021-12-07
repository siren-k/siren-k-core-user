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
        private String description;
        // 상위 부서 정보
        private String parentToken;
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
        private String description;
        @NotNull(message = "enable: 필수값입니다")
        private boolean enable;
        // 추가 정보
        private int order;
    }

    @Getter
    @Setter
    @ToString
    public static class MoveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // 상위 부서 정보
        @NotNull(message = "parentToken: 필수값입니다")
        private String parentToken;
    }

    @Getter
    @Setter
    @ToString
    public static class RemoveRequest {
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    public record BasicParentResponse(String token, String name, String description, String path,
                                      boolean enable, int order,
                                      DepartmentDto.BasicParentResponse parent) {
    }

    @Getter
    @Builder
    @ToString
    public static class BasicChildrenResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
        private final String path;
        private final boolean enable;
        // 하위 부서 정보
        private final List<BasicChildrenResponse> children;
        // 추가 정보
        private final int order;
    }

    public record RemoveResponse(String token) {
    }

}
