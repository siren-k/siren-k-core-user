package com.sirenk.core.user.domain.department;

public interface DepartmentReader {

    Department read(Long id);

    Department read(String token);

    Department readRecursively(String token);

}
