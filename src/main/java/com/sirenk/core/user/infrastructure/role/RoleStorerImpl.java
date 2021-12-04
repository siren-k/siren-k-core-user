package com.sirenk.core.user.infrastructure.role;

import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.user.domain.role.Role;
import com.sirenk.core.user.domain.role.RoleStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleStorerImpl implements RoleStorer {

    private final RoleJpaRepository roleJpaRepository;

    @Override
    public Role store(Role role) {
        if (StringUtils.isEmpty(role.getToken())) throw new InvalidParamException("role.getToken()");
        if (StringUtils.isEmpty(role.getName())) throw new InvalidParamException("role.getName()");
        return roleJpaRepository.save(role);
    }

    @Override
    public void remove(Role role) {
        if (role == null) throw new InvalidParamException("role is null");
        roleJpaRepository.delete(role);
    }

}
