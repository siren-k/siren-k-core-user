package com.sirenk.core.user.interfaces.program.screen.button;

import com.sirenk.core.user.domain.program.screen.button.ScreenButton;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class ScreenButtonDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
        @NotNull(message = "method: 필수값입니다")
        private ScreenButton.Method method;
        @NotNull(message = "url: 필수값입니다")
        private String url;
    }

    @Getter
    @Setter
    @ToString
    public static class ChangeBasicInfoRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
        @NotNull(message = "method: 필수값입니다")
        private ScreenButton.Method method;
        @NotNull(message = "url: 필수값입니다")
        private String url;
        @NotNull(message = "enable: 필수값입니다")
        private boolean enable;
    }

    public record BasicResponse(String token, String name, String description,
                                ScreenButton.Method method, String url,
                                boolean enable) {
    }

}
