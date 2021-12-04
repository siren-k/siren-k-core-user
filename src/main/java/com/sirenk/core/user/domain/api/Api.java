package com.sirenk.core.user.domain.api;

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
    @Column(name = "api_enable")
    private boolean enable;

    @Builder
    public Api(String name, String description) {
        if (StringUtils.isEmpty(name)) throw new InvalidParamException("Api.name");

        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_API);
        this.name = name;
        this.description = description;
        this.enable = true;
    }

    public void changeBasicInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
