package com.sirenk.core.user.interfaces.program.screen;

import com.sirenk.core.user.interfaces.program.screen.button.ScreenButtonDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ScreenDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
        @NotNull(message = "enable: 필수값입니다")
        private boolean enable;
        // 버튼 정보
        private List<ScreenButtonDto.RegisterRequest> buttons;
    }

    @Getter
    @Setter
    @ToString
    public static class RetrieveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
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
        @NotNull(message = "enable: 필수값입니다")
        private boolean enable;
        // 버튼 정보
        private List<ScreenButtonDto.ChangeBasicInfoRequest> buttons;
    }

    @Getter
    @Setter
    @ToString
    public static class AddScreenButtonRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // 버튼 정보
        private List<ScreenButtonDto.RegisterRequest> buttons;
    }

    @Getter
    @Setter
    @ToString
    public static class RemoveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    @Getter
    @Builder
    @ToString
    public static class ScreenBasicResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
        private final boolean enable;
        // 버튼 정보
        private final List<ScreenButtonDto.ScreenButtonBasicResponse> buttons;
    }

    public record ScreenRemoveResponse(String token) {
    }

}
