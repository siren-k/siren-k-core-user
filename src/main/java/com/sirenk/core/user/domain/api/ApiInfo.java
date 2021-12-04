package com.sirenk.core.user.domain.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ApiInfo {

    @Getter
    @Builder
    @ToString
    public static class Basic {
        // 기본 정보
        private String token;
        private String name;
        private String description;
    }

}
