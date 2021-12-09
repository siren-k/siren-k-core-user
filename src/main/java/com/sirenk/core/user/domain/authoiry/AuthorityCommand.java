package com.sirenk.core.user.domain.authoiry;

import com.sirenk.core.user.domain.program.Program;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class AuthorityCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        private String description;

        public Authority toEntity() {
            return Authority.builder()
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
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class AttachProgram {
        // 기본 정보
        private String token;
        // 프로그램 정보
        private String programToken;
        private Program program;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class DetachProgram {
        // 기본 정보
        private String token;
        // 프로그램 정보
        private String programToken;
        private Program program;
    }

}
