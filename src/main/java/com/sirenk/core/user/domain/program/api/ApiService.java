package com.sirenk.core.user.domain.program.api;

public interface ApiService {

    ApiInfo.ApiBasic register(ApiCommand.Register command);

    Api find(ApiCommand.Retrieve command);

    ApiInfo.ApiBasic retrieve(ApiCommand.Retrieve command);

    ApiInfo.ApiBasic changeBasicInfo(ApiCommand.ChangeBasicInfo command);

    ApiInfo.ApiRemove remove(ApiCommand.Remove command);

}
