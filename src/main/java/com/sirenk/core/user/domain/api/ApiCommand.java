package com.sirenk.core.user.domain.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ApiCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        private String description;

        public Api toEntity() {
            return Api.builder()
                    .name(name)
                    .description(description)
                    .build();
        }
    }

}
