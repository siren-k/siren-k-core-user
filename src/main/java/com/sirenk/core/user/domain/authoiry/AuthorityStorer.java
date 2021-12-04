package com.sirenk.core.user.domain.authoiry;

public interface AuthorityStorer {

    Authority store(Authority authority);

    void remove(Authority authority);

}
