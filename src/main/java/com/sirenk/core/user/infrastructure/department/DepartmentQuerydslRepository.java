package com.sirenk.core.user.infrastructure.department;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sirenk.core.user.domain.department.Department;
import com.sirenk.core.user.domain.department.QDepartment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Slf4j
@Component
@RequiredArgsConstructor
public class DepartmentQuerydslRepository {

    private final EntityManager entityManager;

    public Department findByTokenRecursively(String token) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QDepartment parent = new QDepartment("parent");
        QDepartment child = new QDepartment("child");

        return jpaQueryFactory.selectFrom(parent)
                .distinct()
                .leftJoin(parent.children, child)
                .fetchJoin()
                .where(parent.token.eq(token))
                .fetchOne();
    }

}
