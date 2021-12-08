package com.sirenk.core.user.domain.program;

import com.sirenk.core.user.domain.program.api.ApiInfo;
import com.sirenk.core.user.domain.program.screen.ScreenInfo;
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
        // 화면 정보
        private ScreenInfo.Basic screen;
        // API 정보
        private ApiInfo.Basic api;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
