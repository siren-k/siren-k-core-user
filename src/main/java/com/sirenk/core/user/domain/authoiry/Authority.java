package com.sirenk.core.user.domain.authoiry;

import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "authority")
public class Authority extends AbstractEntity {

    private static final String PREFIX_AUTHORITY = "AUTH_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long id;
    @Column(name = "authority_token")
    private String token;
    @Column(name = "authority_name")
    private String name;
    @Column(name = "authority_description")
    private String description;
    @Column(name = "authority_enable")
    private boolean enable;

    @Builder
    public Authority(String name, String description) {
        if (StringUtils.isEmpty(name)) throw new InvalidParamException("Authority.name");

        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_AUTHORITY);
        this.name = name;
        this.description = description;
        this.enable = true;
    }

    public void changeBasicInfo(String name, String description, boolean enable) {
        this.name = name;
        this.description = description;
        this.enable = enable;
    }

}
