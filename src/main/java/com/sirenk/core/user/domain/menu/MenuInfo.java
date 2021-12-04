package com.sirenk.core.user.domain.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class MenuInfo {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Basic {
        private String token;
        private String name;
        private String description;
        private String path;
        private Basic parent;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Retrieve {
        private String token;
        private String name;
        private String description;
        private String path;
        private List<Retrieve> children;
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
    @Builder(toBuilder = true)
    @ToString
    public static class Move {
        private String token;
        private String name;
        private String description;
        private String path;
        private Move parent;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        private String token;
    }

}
