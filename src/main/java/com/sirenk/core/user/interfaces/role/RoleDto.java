package com.sirenk.core.user.interfaces.role;

import com.sirenk.core.user.interfaces.authority.AuthorityDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

public class RoleDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        // 기본 정보
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
    }


    @Getter
    @Setter
    @ToString
    public static class RetrieveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    @Getter
    @Setter
    @ToString
    public static class ChangeBasicInfoRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        @NotNull(message = "name: 필수값입니다")
        private String name;
        private String description;
        @NotNull(message = "enable: 필수값입니다")
        private boolean enable;
    }

    @Getter
    @Setter
    @ToString
    public static class AttachAuthorityRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // 권한 정보
        @NotNull(message = "authorityToken: 필수값입니다")
        private String authorityToken;
    }

    @Getter
    @Setter
    @ToString
    public static class DetachAuthorityRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
        // 권한 정보
        @NotNull(message = "authorityToken: 필수값입니다")
        private String authorityToken;
    }

    @Getter
    @Setter
    @ToString
    public static class RemoveRequest {
        // 기본 정보
        @NotNull(message = "token: 필수값입니다")
        private String token;
    }

    @Getter
    @Builder
    @ToString
    public static class RoleBasicResponse {
        // 기본 정보
        private final String token;
        private final String name;
        private final String description;
        private final boolean enable;
        // 권한 정보
        private final List<AuthorityDto.AuthorityBasicResponse> authorities;
    }

    public record RoleRemoveResponse(String token) {
    }

}
