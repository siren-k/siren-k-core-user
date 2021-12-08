package com.sirenk.core.user.domain.program.screen;

import com.google.common.collect.Lists;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import com.sirenk.core.user.domain.program.Program;
import com.sirenk.core.user.domain.program.screen.button.ScreenButton;
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
@Table(name = "screen")
public class Screen extends AbstractEntity {

    private static final String PREFIX_SCREEN = "SRN_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "screen_id")
    private Long id;
    @Column(name = "screen_token")
    private String token;
    @Column(name = "screen_name")
    private String name;
    @Column(name = "screen_description")
    private String description;
    @Column(name = "screen_enable")
    private boolean enable;

    // 버튼 정보
    @OneToMany(mappedBy = "screen")
    private List<ScreenButton> buttons = Lists.newArrayList();

    // 프로그램 정보
    @OneToOne(mappedBy = "screen")
    private Program program;

    @Builder
    public Screen(
            String name, String description,
            List<ScreenButton> buttons
    ) {
        if (StringUtils.isEmpty(name)) throw new InvalidParamException("Screen.name");

        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_SCREEN);
        this.name = name;
        this.description = description;
        this.enable = true;

        // 버튼 정보
        this.buttons = buttons;
    }

    public void changeBasicInfo(String name, String description, boolean enable) {
        this.name = name;
        this.description = description;
        this.enable = enable;
    }

}
