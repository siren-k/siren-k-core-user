package com.sirenk.core.user.domain.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class MenuCommand {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        private String description;
        // 상위 메뉴 정보
        private String parentToken;
        private Menu parent;

        public Menu toEntity() {
            return Menu.builder()
                    .name(name)
                    .description(description)
                    .parent(parent)
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
    public static class Move {
        private String token;
        private String parentToken;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        private String token;
    }

}
