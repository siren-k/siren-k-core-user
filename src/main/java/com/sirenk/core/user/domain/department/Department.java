package com.sirenk.core.user.domain.department;

import com.google.common.collect.Lists;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.common.jpa.AbstractEntity;
import com.sirenk.core.common.util.TokenGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "department")
public class Department extends AbstractEntity {

    private static final String PREFIX_DEPARTMENT = "DEPT_";

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;
    @Column(name = "department_token")
    private String token;
    @Column(name = "department_name")
    private String name;
    @Column(name = "department_description")
    private String description;
    @Column(name = "department_path", length = 2048)
    private String path;
    @Column(name = "department_enable")
    private boolean enable;

    // 상위 부서 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_parent_id")
    private Department parent;
    @OneToMany(mappedBy = "parent")
    private final List<Department> children = Lists.newArrayList();

    // 추가 정보
    @Column(name = "department_order")
    private int order;
    // private User header;

    @Builder
    public Department(
            String name,
            String description,
            Department parent,
            int order
    ) {
        if (StringUtils.isEmpty(name)) throw new InvalidParamException("Department.name");

        // 기본 정보
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_DEPARTMENT);
        this.name = name;
        this.description = description;
        this.enable = true;

        // 상위 부서 정보
        this.path = getParentPath(parent) + name;
        this.parent = parent;

        // 추가 정보
        this.order = order;
    }

    public void changeBasicInfo(String name, String description, boolean enable, int order) {
        this.name = name;
        this.description = description;
        this.enable = enable;
        this.order = order;
        changeParent(parent);
        for (Department child : children) {
            child.renewPath();
        }
    }

    public void changeParent(Department parent) {
        this.parent = parent;
        this.path = getParentPath(parent) + name;
    }

    public void renewPath() {
        this.path = getParentPath(this.parent) + name;
        for (Department department : this.children) {
            department.renewPath();
        }
    }

    private String getParentPath(Department parent) {
        return parent != null ? parent.getPath() + " > " : "";
    }

}
