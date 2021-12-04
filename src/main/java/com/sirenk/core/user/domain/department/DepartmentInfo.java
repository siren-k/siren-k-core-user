package com.sirenk.core.user.domain.department;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class DepartmentInfo {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Basic {
        // 기본 정보
        private String token;
        private String name;
        private String path;
        private int order;
        // 상위 부서 정보
        private Basic parent;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Hierarchy {
        // 기본 정보
        private String token;
        private String name;
        private String path;
        private int order;
        // 하위 부서 정보
        private List<Hierarchy> children;
    }

    @Getter
    @Builder
    @ToString
    public static class ChangeBasicInfo {
        // 기본 정보
        private String token;
        private String name;
        private String path;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Move {
        // 기본 정보
        private String token;
        private String name;
        private String path;
        private int order;
        // 상위 부서 정보
        private Move parent;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
