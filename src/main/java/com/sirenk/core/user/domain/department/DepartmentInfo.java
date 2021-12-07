package com.sirenk.core.user.domain.department;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class DepartmentInfo {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class BasicParent {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        private String path;
        // 상위 부서 정보
        private BasicParent parent;
        // 기타 정보
        private int order;
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
        private String path;
        // 하위 부서 정보
        private List<BasicChildren> children;
        // 기타 정보
        private int order;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
