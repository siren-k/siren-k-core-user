package com.sirenk.core.user.domain.program;

public interface ProgramReader {

    Program read(Long id);

    Program read(String token);

}
