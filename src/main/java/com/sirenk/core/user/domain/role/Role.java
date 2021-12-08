package com.sirenk.core.user.domain.role;

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
@Table(name = "role")
public class Role extends AbstractEntity {

    private static final String PREFIX_ROLE = "RLE_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role_token")
    private String token;
    @Column(name = "role_name")
    private String name;
    @Column(name = "role_description")
    private String description;
    @Column(name = "role_enable")
    private boolean enable;

    @Builder
    public Role(String name, String description
    ) {
        if (StringUtils.isEmpty(name)) throw new InvalidParamException("Role.name");

        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_ROLE);
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
