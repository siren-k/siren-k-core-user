package com.sirenk.core.user.domain.department;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class DepartmentCommand {

    @Getter
    @Builder(toBuilder = true)
    @ToString
    public static class Register {
        // 기본 정보
        private String name;
        // 상위 부서 정보
        private String parentToken;
        private Department parent;

        public Department toEntity() {
            return Department.builder()
                    .name(name)
                    .parent(parent)
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
    }

    @Getter
    @Builder
    @ToString
    public static class Move {
        // 기본 정보
        private String token;
        // 상위 부서 정보
        private String parentToken;
    }

    @Getter
    @Builder
    @ToString
    public static class Remove {
        // 기본 정보
        private String token;
    }

}
