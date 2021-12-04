package com.sirenk.core.user.domain.program;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ProgramCommand {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Register {
        private String name;
        private String description;

        public Program toEntity() {
            return Program.builder()
                    .name(name)
                    .description(description)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class Retrieve {
        private String token;
    }

    @Getter
    @Builder
    @ToString
    public static class ChangeBasicInfo {
        private String token;
        private String name;
        private String description;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        private String token;
    }

}
