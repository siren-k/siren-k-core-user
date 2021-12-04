package com.sirenk.core.user.domain.api;

public interface ApiService {

    ApiInfo.Basic register(ApiCommand.Register command);

    ApiInfo.Retrieve retrieve(ApiCommand.Retrieve command);

    ApiInfo.ChangeBasicInfo changeBasicInfo(ApiCommand.ChangeBasicInfo command);

    ApiInfo.Remove remove(ApiCommand.Remove command);

}
