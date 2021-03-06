package com.sirenk.core.user.domain.role;

import com.google.common.collect.Lists;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import com.sirenk.core.user.domain.authoiry.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

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

    // 권한 정보
    @OneToMany(mappedBy = "role")
    private List<Authority> authorities = Lists.newArrayList();

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

    public void attachAuthority(Authority authority) {
        this.authorities.add(authority);
        authority.attachRole(this);
    }

    public void detachAuthority(Authority authority) {
        this.authorities.remove(authority);
        authority.detachAuthority();
    }

}
