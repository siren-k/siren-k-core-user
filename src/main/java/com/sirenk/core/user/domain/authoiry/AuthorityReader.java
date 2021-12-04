package com.sirenk.core.user.domain.authoiry;

public interface AuthorityReader {

    Authority read(Long id);

    Authority read(String token);

}
