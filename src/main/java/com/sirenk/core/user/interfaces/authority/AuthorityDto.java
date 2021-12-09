package com.sirenk.core.user.interfaces.authority;

import com.sirenk.core.user.interfaces.program.ProgramDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AuthorityDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
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
    }

    @Getter
    @Setter
    @ToString
    public static class AttachProgramRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // 프로그팸 정보
        @NotNull(message = "programToken: 필수값입니다")
        private String programToken;
    }

    @Getter
    @Setter
    @ToString
    public static class DeattachProgramRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // 프로그팸 정보
        @NotNull(message = "programToken: 필수값입니다")
        private String programToken;
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
    public static class AuthorityBasicResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
        private final boolean enable;
        // 프로그램 정보
        private final List<ProgramDto.ProgramBasicResponse> programs;
    }

    public record AuthorityRemoveResponse(String token) {
    }

}
