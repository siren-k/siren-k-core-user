package com.sirenk.core.user.domain.program;

import com.sirenk.core.user.domain.program.api.Api;
import com.sirenk.core.user.domain.program.screen.Screen;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ProgramCommand {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        private String description;
        // 화면 정보
        private String screenToken;
        private Screen screen;
        // API 정보
        private String apiToken;
        private Api api;

        public Program toEntity() {
            return Program.builder()
                    .name(name)
                    .description(description)
                    .screen(screen)
                    .api(api)
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
        private boolean enable;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class ChangeScreen {
        // 기본 정보
        private String token;
        // 화면 정보
        private String screenToken;
        private Screen screen;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class ChangeApi {
        // 기본 정보
        private String token;
        // 화면 정보
        private String apiToken;
        private Api api;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
