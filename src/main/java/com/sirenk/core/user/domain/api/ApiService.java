package com.sirenk.core.user.domain.api;

public interface ApiService {

    ApiInfo.Basic register(ApiCommand.Register command);

}
