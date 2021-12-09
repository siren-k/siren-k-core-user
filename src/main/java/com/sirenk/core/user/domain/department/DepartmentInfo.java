package com.sirenk.core.user.domain.department;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class DepartmentInfo {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class DepartmentBasicParent {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        private String path;
        // 상위 부서 정보
        private DepartmentBasicParent parent;
        // 기타 정보
        private int order;
    }

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class DepartmentBasicChildren {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        private String path;
        // 하위 부서 정보
        private List<DepartmentBasicChildren> children;
        // 기타 정보
        private int order;
    }

    @Getter
    @Builder
    @ToString
    public static class DepartmentRemove {
        // 기본 정보
        private String token;
    }

}
