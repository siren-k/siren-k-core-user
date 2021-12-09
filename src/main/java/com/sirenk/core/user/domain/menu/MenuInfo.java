package com.sirenk.core.user.domain.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class MenuInfo {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class MenuBasicParent {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        // 상위 메뉴 정보
        private String path;
        private MenuBasicParent parent;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class MenuBasicChildren {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        // 하위 메뉴 정보
        private String path;
        private List<MenuBasicChildren> children;
    }

    @Getter
    @Builder
    @ToString
    public static class MenuRemove {
        // 기본 정보
        private String token;
    }

}
