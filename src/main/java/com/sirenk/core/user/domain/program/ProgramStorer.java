package com.sirenk.core.user.domain.program;

public interface ProgramStorer {

    Program store(Program program);

    void remove(Program program);

}
