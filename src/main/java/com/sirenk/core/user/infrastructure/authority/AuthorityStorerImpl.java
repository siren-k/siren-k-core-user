package com.sirenk.core.user.infrastructure.authority;

import com.sirenk.core.common.exception.EntityDuplicationException;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.user.domain.authoiry.Authority;
import com.sirenk.core.user.domain.authoiry.AuthorityStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorityStorerImpl implements AuthorityStorer {

    private final AuthorityJpaRepository authorityJpaRepository;

    @Override
    public Authority store(Authority authority) {
        if (authority == null) throw new InvalidParamException("authority is null");
        if (StringUtils.isEmpty(authority.getToken())) throw new InvalidParamException("authority.getToken()");
        if (StringUtils.isEmpty(authority.getName())) throw new InvalidParamException("authority.getName()");

        try {
            return authorityJpaRepository.save(authority);
        } catch (DataIntegrityViolationException e) {
            throw new EntityDuplicationException(e.getMessage());
        }
    }

    @Override
    public void remove(Authority authority) {
        if (authority == null) throw new InvalidParamException("authority is null");
        authorityJpaRepository.delete(authority);
    }

}
