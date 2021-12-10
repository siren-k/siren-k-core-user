package com.sirenk.core.user.domain.user;

import com.sirenk.core.common.exception.AuthenticationException;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.response.ErrorCode;
import com.sirenk.core.common.util.TokenGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User extends AbstractEntity {

    private static final String PREFIX_USER = "USR_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_token")
    private String token;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_enable")
    private boolean enable;

    // 인증 정보
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_authentication_retry_count")
    private int authenticationRetryCount;
    @Column(name = "user_last_password_change_date")
    private ZonedDateTime lastPasswordChangeDate;
    @Column(name = "user_locked")
    private boolean locked;

    // 개인정보
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_cell_phone")
    private String cellPhone;
    @Column(name = "user_work_phone")
    private String workPhone;
    @Column(name = "user_address_1")
    private String address1;
    @Column(name = "user_address_2")
    private String address2;
    @Column(name = "user_address_3")
    private String address3;
    @Column(name = "user_address_4")
    private String address4;
    @Column(name = "user_address_5")
    private String address5;

    @Builder
    public User(String name, String password, String email
    ) {
        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_USER);
        this.name = name;
        this.enable = true;

        // 인증 정보
        this.password = password;
        this.authenticationRetryCount = 0;
        this.lastPasswordChangeDate = ZonedDateTime.now();
        this.locked = false;

        // 개인 정보
        this.email = email;
    }

    public void changePassword(String currentPassword, String newPassword) {
        if (password.equals(currentPassword)) {
            this.password = newPassword;
            this.authenticationRetryCount = 0;
            this.lastPasswordChangeDate = ZonedDateTime.now();
        } else {
            throw new AuthenticationException(
                    ErrorCode.AUTHENTICATION_ERROR
                            .getErrorMsg("현재 비밀번호가 동일하지 않습니다")
            );
        }
    }

}
