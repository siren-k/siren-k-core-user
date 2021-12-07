package com.sirenk.core.user.domain.menu;

import com.google.common.collect.Lists;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "menu")
public class Menu extends AbstractEntity {

    private static final String PREFIX_PROGRAM = "MNU_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;
    @Column(name = "menu_token")
    private String token;
    @Column(name = "menu_name")
    private String name;
    @Column(name = "menu_description")
    private String description;
    @Column(name = "menu_enable")
    private boolean enable;

    // 상위 프로그램 정보
    @Column(name = "menu_path", length = 4096)
    private String path;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_parent_id")
    private Menu parent;
    @OneToMany(mappedBy = "parent")
    private final List<Menu> children = Lists.newArrayList();

    @Builder
    public Menu(String name, String description, Menu parent) {
        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_PROGRAM);
        this.name = name;
        this.description = description;
        this.enable = true;

        // 상위 프로그램 정보
        this.path = getParentPath(parent) + name;
        this.parent = parent;
    }

    public void changeParent(Menu parent) {
        this.parent = parent;
        this.path = getParentPath(parent) + name;
    }

    public void renewPath() {
        this.path = getParentPath(this.parent) + name;
        for (Menu menu : this.children) {
            menu.renewPath();
        }
    }

    private String getParentPath(Menu parent) {
        return parent != null ? parent.getPath() + " > " : "";
    }

    public void changeBasicInfo(String name, String description, boolean enable) {
        this.name = name;
        this.description = description;
        this.enable = enable;
    }

    public void enable() {
        this.enable = true;
    }

    public void disable() {
        this.enable = false;
    }

}
