package com.sirenk.core.user.infrastructure.api;

import com.sirenk.core.user.domain.api.Api;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiJpaRepository extends JpaRepository<Api, Long> {

    Optional<Api> findByToken(String token);

}
