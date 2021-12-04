package com.sirenk.core.user.infrastructure.department;

import com.sirenk.core.common.exception.EntityDuplicationException;
import com.sirenk.core.common.exception.InvalidParamException;
import com.sirenk.core.user.domain.department.Department;
import com.sirenk.core.user.domain.department.DepartmentStorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DepartmentStorerImpl implements DepartmentStorer {

    private final DepartmentJpaRepository departmentRepository;

    @Override
    public Department store(Department department) {
        if (department == null) throw new InvalidParamException("department is null");
        if (StringUtils.isEmpty(department.getToken())) throw new InvalidParamException("department.getToken()");
        if (StringUtils.isEmpty(department.getName())) throw new InvalidParamException("department.getName()");
        if (StringUtils.isEmpty(department.getPath())) throw new InvalidParamException("department.getPath()");

        try {
            return departmentRepository.save(department);
        } catch (DataIntegrityViolationException e) {
            throw new EntityDuplicationException(e.getMessage());
        }
    }

    @Override
    public void remove(Department department) {
        if (department == null) throw new InvalidParamException("department is null");
        departmentRepository.delete(department);
    }

}
