package com.sirenk.core.user.infrastructure.department;

import com.sirenk.core.user.domain.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByToken(String token);

}

