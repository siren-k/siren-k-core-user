package com.sirenk.core.user.infrastructure.program.screen;

import com.sirenk.core.user.domain.program.screen.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScreenJpaRepository extends JpaRepository<Screen, Long> {

    Optional<Screen> findByToken(String token);

}
