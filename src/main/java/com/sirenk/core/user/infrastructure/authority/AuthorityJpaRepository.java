package com.sirenk.core.user.infrastructure.authority;

import com.sirenk.core.user.domain.authoiry.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityJpaRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByToken(String token);

}
