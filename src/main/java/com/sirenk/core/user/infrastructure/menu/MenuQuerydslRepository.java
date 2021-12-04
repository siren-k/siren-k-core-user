package com.sirenk.core.user.infrastructure.menu;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sirenk.core.user.domain.menu.Menu;
import com.sirenk.core.user.domain.menu.QMenu;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuQuerydslRepository {

    private final EntityManager entityManager;

    public Menu findByTokenRecursively(String token) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QMenu parent = new QMenu("parent");
        QMenu child = new QMenu("child");

        return jpaQueryFactory.selectFrom(parent)
                .distinct()
                .leftJoin(parent.children, child)
                .fetchJoin()
                .where(parent.token.eq(token))
                .fetchOne();
    }

}
