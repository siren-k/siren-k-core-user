package com.sirenk.core.user.domain.program.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ApiCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        private String description;
        private Api.Method method;

        public Api toEntity() {
            return Api.builder()
                    .name(name)
                    .description(description)
                    .method(method)
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
        private Api.Method method;
        private boolean enable;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
