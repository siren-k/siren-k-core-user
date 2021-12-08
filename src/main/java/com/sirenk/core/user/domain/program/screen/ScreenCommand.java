package com.sirenk.core.user.domain.program.screen;

import com.sirenk.core.user.domain.program.screen.button.ScreenButtonCommand;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class ScreenCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        private String description;

        // 버튼 정보
        private List<ScreenButtonCommand.Register> buttons;

        public Screen toEntity() {
            return Screen.builder()
                    .name(name)
                    .description(description)
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
        // 버튼 정보
        private List<ScreenButtonCommand.ChangeBasicInfo> buttons;
    }

    @Getter
    @Builder
    @ToString
    public static class AddScreenButton {
        // 기본 정보
        private String token;
        // 버튼 정보
        private List<ScreenButtonCommand.Register> buttons;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
