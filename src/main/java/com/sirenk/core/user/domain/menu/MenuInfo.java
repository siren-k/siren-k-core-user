package com.sirenk.core.user.domain.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class MenuInfo {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class BasicParent {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        // 상위 메뉴 정보
        private String path;
        private BasicParent parent;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class BasicChildren {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        // 하위 메뉴 정보
        private String path;
        private List<BasicChildren> children;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
