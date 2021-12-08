package com.sirenk.core.user.interfaces.program;

import com.sirenk.core.user.interfaces.program.api.ApiDto;
import com.sirenk.core.user.interfaces.program.screen.ScreenDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class ProgramDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
        // 화면 정보
        private String screenToken;
        // API 정보
        private String apiToken;
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
        private String token;
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
        @NotNull(message = "enable: 필수값입니다")
        private boolean enable;
    }

    @Getter
    @Setter
    @ToString
    public static class ChangeScreenRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // 화면 정보
        @NotNull(message = "screenToken: 필수값입니다")
        private String screenToken;
    }

    @Getter
    @Setter
    @ToString
    public static class ChangeApiRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // API 정보
        @NotNull(message = "apiToken: 필수값입니다")
        private String apiToken;
    }

    @Getter
    @Setter
    @ToString
    public static class RemoveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    public record BasicResponse(String token, String name, String description, boolean enable,
                                ScreenDto.BasicResponse screen,
                                ApiDto.BasicResponse api) {
    }

    public record RemoveResponse(String token) {
    }

}
