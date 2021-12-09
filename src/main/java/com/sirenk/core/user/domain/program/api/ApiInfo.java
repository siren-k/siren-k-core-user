package com.sirenk.core.user.domain.program.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ApiInfo {

    @Getter
    @Builder
    @ToString
    public static class ApiBasic {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private Api.Method method;
        private String url;
        private boolean enable;
    }

    @Getter
    @Builder
    @ToString
    public static class ApiRemove {
        // 기본 정보
        private String token;
    }

}
