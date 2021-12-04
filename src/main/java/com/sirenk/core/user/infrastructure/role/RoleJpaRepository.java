package com.sirenk.core.user.infrastructure.role;

import com.sirenk.core.user.domain.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleJpaRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByToken(String token);

}
