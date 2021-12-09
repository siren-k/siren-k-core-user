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
    public static class ProgramBasic {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        // 화면 정보
        private ScreenInfo.ScreenBasic screen;
        // API 정보
        private ApiInfo.ApiBasic api;
    }

    @Getter
    @Builder
    @ToString
    public static class ProgramRemove {
        // 기본 정보
        private String token;
    }

}
