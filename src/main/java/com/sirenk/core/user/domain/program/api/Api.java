package com.sirenk.core.user.domain.program.api;

import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import com.sirenk.core.user.domain.program.Program;
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
@Table(name = "api")
public class Api extends AbstractEntity {

    private static final String PREFIX_API = "API_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    private Long id;
    @Column(name = "api_token")
    private String token;
    @Column(name = "api_name")
    private String name;
    @Column(name = "api_description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "api_method")
    private Method method;
    @Column(name = "api_enable")
    private boolean enable;

    // 프로그램 정보
    @OneToOne(mappedBy = "api")
    private Program program;

    @Builder
    public Api(String name, String description, Method method,
               Program program
    ) {
        if (StringUtils.isEmpty(name)) throw new InvalidParamException("Api.name");

        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_API);
        this.name = name;
        this.description = description;
        this.method = method;
        this.enable = true;

        // 프로그램 정보
        this.program = program;
    }

    public void changeBasicInfo(String name, String description, boolean enable, Method method) {
        this.name = name;
        this.description = description;
        this.enable = enable;
        this.method = method;
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
