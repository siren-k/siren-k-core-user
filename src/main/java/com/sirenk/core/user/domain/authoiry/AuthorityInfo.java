package com.sirenk.core.user.domain.authoiry;

import com.sirenk.core.user.domain.program.ProgramInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class AuthorityInfo {

    @Getter
    @Builder
    @ToString
    public static class AuthorityBasic {
        // 기본 정보
        private String token;
        private String name;
        private String description;
        private boolean enable;
        // 프로그램 정보
        private List<ProgramInfo.ProgramBasic> programs;
    }

    @Getter
    @Builder
    @ToString
    public static class AuthorityRemove {
        // 기본 정보
        private String token;
    }

}
