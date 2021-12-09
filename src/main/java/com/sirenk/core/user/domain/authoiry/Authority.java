package com.sirenk.core.user.domain.authoiry;

import com.google.common.collect.Lists;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import com.sirenk.core.user.domain.program.Program;
import com.sirenk.core.user.domain.role.Role;
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

    // 프로그램 정보
    @OneToMany(mappedBy = "authority")
    private List<Program> programs = Lists.newArrayList();

    // 역할 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Builder
    public Authority(String name, String description
    ) {
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

    public void attachProgram(Program program) {
        this.programs.add(program);
        program.attachAuthority(this);
    }

    public void detachProgram(Program program) {
        this.programs.remove(program);
        program.detachAuthority();
    }

    public void attachRole(Role role) {
        this.role = role;
    }

    public void detachAuthority() {
        this.role = null;
    }

}
