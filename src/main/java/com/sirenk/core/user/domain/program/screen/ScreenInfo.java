package com.sirenk.core.user.domain.program.screen;

import com.sirenk.core.user.domain.program.screen.button.ScreenButtonInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class ScreenInfo {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class ScreenBasic {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        // 버튼 정보
        private List<ScreenButtonInfo.ScreenButtonBasic> buttons;
    }

    @Getter
    @Builder
    @ToString
    public static class ScreenRemove {
        // 기본 정보
        private String token;
    }

}
