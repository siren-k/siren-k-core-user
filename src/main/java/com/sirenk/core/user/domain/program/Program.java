package com.sirenk.core.user.domain.program;

import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import com.sirenk.core.user.domain.program.screen.Screen;
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

    // 화면 정보
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @Builder
    public Program(
            String name,
            String description,
            Screen screen
    ) {
        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_PROGRAM);
        this.name = name;
        this.description = description;
        this.enable = true;

        // 화면 정보
        this.screen = screen;
    }

    public void changeBasicInfo(String name, String description, boolean enable) {
        this.name = name;
        this.description = description;
        this.enable = enable;
    }

    public void changeScreen(Screen screen) {
        this.screen = screen;
    }

}
