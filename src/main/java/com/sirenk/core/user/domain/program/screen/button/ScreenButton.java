package com.sirenk.core.user.domain.program.screen.button;

import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import com.sirenk.core.user.domain.program.screen.Screen;
import lombok.AllArgsConstructor;
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
@Table(name = "screen_button")
public class ScreenButton extends AbstractEntity {

    private static final String PREFIX_SCREEN_BUTTON = "BTN_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "screen_button_id")
    private Long id;
    @Column(name = "screen_button_token")
    private String token;
    @Column(name = "screen_button_name")
    private String name;
    @Column(name = "screen_button_description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "screen_button_method")
    private Method method;
    @Column(name = "screen_button_url", length = 4096)
    private String url;
    @Column(name = "screen_button_enable")
    private boolean enable;

    // 화면 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @Builder
    public ScreenButton(String name, String description,
                        Method method, String url,
                        Screen screen
    ) {
        if (StringUtils.isEmpty(name)) throw new InvalidParamException("Button.name");
        if (method == null) throw new InvalidParamException("Button.method");
        if (StringUtils.isEmpty(url)) throw new InvalidParamException("Button.url");
        if (screen == null) throw new InvalidParamException("Button.screen");

        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_SCREEN_BUTTON);
        this.name = name;
        this.description = description;
        this.method = method;
        this.url = url;
        this.enable = true;

        // 화면 정보
        this.screen = screen;
    }

    public void changeBasicInfo(
            String name, String description,
            Method method, String url, boolean enable
    ) {
        this.name = name;
        this.description = description;
        this.method = method;
        this.url = url;
        this.enable = enable;
    }

    @Getter
    @AllArgsConstructor
    public enum Method {
        GET("HTTP GET Method"),
        POST("HTTP POST Method"),
        PUT("HTTP PUT Method"),
        DELETE("HTTP DELETE Method");
        private final String description;
    }

}
