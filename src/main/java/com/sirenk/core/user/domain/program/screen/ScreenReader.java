package com.sirenk.core.user.domain.program.screen;

public interface ScreenReader {

    Screen read(Long id);

    Screen read(String token);

}
