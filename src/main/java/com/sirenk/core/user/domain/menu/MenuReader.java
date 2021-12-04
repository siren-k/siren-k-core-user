package com.sirenk.core.user.domain.menu;

import java.util.List;

public interface MenuReader {

    List<Menu> read();

    Menu read(Long id);

    Menu read(String token);

    Menu readRecursively(String token);
    
}
