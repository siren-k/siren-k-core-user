package com.sirenk.core.user.infrastructure.role;

import com.sirenk.core.common.exception.EntityNotFoundException;
import com.sirenk.core.user.domain.role.Role;
import com.sirenk.core.user.domain.role.RoleReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleReaderImpl implements RoleReader {

    private final RoleJpaRepository roleJpaRepository;

    @Override
    public Role read(Long id) {
        return roleJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Role read(String token) {
        return roleJpaRepository.findByToken(token)
                .orElseThrow(EntityNotFoundException::new);
    }

}
