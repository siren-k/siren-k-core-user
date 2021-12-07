package com.sirenk.core.user.domain.screen;

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

    @Builder
    public Screen(String name, String description) {
        if (StringUtils.isEmpty(name)) throw new InvalidParamException("Screen.name");

        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_SCREEN);
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
