package com.sirenk.core.user.domain.program;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ProgramInfo {

    @Getter
    @Builder
    @ToString
    public static class Basic {
        // 기본 정보
        private String token;
        private String name;
        private String description;
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
