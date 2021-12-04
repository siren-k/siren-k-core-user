package com.sirenk.core.user.domain.api;

public interface ApiReader {

    Api read(Long id);

    Api read(String token);

}
