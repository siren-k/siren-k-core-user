package com.sirenk.core.user.infrastructure.menu;

import com.sirenk.core.user.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuJpaRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> findByToken(String token);
  
    List<Menu> findAllByParentIsNull();

}
