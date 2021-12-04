package com.sirenk.core.user.infrastructure.program;

import com.sirenk.core.user.domain.program.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramJpaRepository extends JpaRepository<Program, Long> {

    Optional<Program> findByToken(String token);

}
