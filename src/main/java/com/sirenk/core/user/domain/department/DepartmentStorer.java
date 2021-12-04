package com.sirenk.core.user.domain.department;

public interface DepartmentStorer {

    Department store(Department department);

    void remove(Department department);

}
