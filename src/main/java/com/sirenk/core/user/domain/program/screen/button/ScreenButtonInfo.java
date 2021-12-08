package com.sirenk.core.user.domain.program.screen.button;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ScreenButtonInfo {

    @Getter
    @Builder
    @ToString
    public static class Basic {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private ScreenButton.Method method;
        private String url;
        private boolean enable;
    }

}
