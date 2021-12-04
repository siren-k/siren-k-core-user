package com.sirenk.core.user.domain.program;

import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "program")
public class Program extends AbstractEntity {

    private static final String PREFIX_PROGRAM = "PRG_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Long id;
    @Column(name = "program_token")
    private String token;
    @Column(name = "program_name")
    private String name;
    @Column(name = "program_description")
    private String description;
    @Column(name = "program_enable")
    private boolean enable;

    @Builder
    public Program(String name, String description) {
        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_PROGRAM);
        this.name = name;
        this.description = description;
        this.enable = true;
    }

    public void changeBasicInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
