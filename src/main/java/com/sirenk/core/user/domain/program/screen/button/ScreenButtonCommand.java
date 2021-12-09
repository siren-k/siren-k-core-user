package com.sirenk.core.user.domain.program.screen.button;

import com.sirenk.core.user.domain.program.screen.Screen;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ScreenButtonCommand {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        private String description;
        private ScreenButton.Method method;
        private String url;
        // 화면 정보
        private Screen screen;

        public ScreenButton toEntity() {
            return ScreenButton.builder()
                    .name(name)
                    .description(description)
                    .method(method)
                    .url(url)
                    .screen(screen)
                    .build();
        }
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class ChangeBasicInfo {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private ScreenButton.Method method;
        private String url;
        private boolean enable;
        // 화면 정보
        private Screen screen;
    }

}
