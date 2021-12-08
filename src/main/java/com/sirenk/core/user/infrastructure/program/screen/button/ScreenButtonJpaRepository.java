package com.sirenk.core.user.infrastructure.program.screen.button;

import com.sirenk.core.user.domain.program.screen.button.ScreenButton;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScreenButtonJpaRepository extends JpaRepository<ScreenButton, Long> {

    Optional<ScreenButton> findByToken(String token);

}
