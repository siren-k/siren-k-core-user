package com.sirenk.core.user.domain.screen;

public interface ScreenReader {

    Screen read(Long id);

    Screen read(String token);

}
