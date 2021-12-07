package com.sirenk.core.user.domain.api;

public interface ApiService {

    ApiInfo.Basic register(ApiCommand.Register command);

    ApiInfo.Basic retrieve(ApiCommand.Retrieve command);

    ApiInfo.Basic changeBasicInfo(ApiCommand.ChangeBasicInfo command);

    ApiInfo.Remove remove(ApiCommand.Remove command);

}
