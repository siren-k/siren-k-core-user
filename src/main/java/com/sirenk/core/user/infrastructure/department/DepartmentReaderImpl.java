package com.sirenk.core.user.infrastructure.department;

import com.sirenk.core.common.exception.EntityNotFoundException;
import com.sirenk.core.user.domain.department.Department;
import com.sirenk.core.user.domain.department.DepartmentReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DepartmentReaderImpl implements DepartmentReader {

    private final DepartmentJpaRepository departmentJpaRepository;
    private final DepartmentQuerydslRepository departmentQuerydslRepository;

    @Override
    public Department read(Long id) {
        return departmentJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Department read(String token) {
        return departmentJpaRepository.findByToken(token)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Department readRecursively(String token) {
        return departmentQuerydslRepository.findByTokenRecursively(token);
    }

}
