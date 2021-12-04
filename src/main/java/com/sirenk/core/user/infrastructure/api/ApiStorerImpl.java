package com.sirenk.core.user.infrastructure.api;

import com.sirenk.core.common.exception.EntityDuplicationException;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.user.domain.api.Api;
import com.sirenk.core.user.domain.api.ApiStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiStorerImpl implements ApiStorer {

    private final ApiJpaRepository apiJpaRepository;

    @Override
    public Api store(Api api) {
        if (api == null) throw new InvalidParamException("api is null");
        if (StringUtils.isEmpty(api.getToken())) throw new InvalidParamException("api.getToken()");
        if (StringUtils.isEmpty(api.getName())) throw new InvalidParamException("api.getName()");

        try {
            return apiJpaRepository.save(api);
        } catch (DataIntegrityViolationException e) {
            throw new EntityDuplicationException(e.getMessage());
        }
    }

}
