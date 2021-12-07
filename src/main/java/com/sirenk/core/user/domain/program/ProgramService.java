package com.sirenk.core.user.domain.program;

public interface ProgramService {

    ProgramInfo.Basic register(ProgramCommand.Register command);

    ProgramInfo.Basic retrieve(ProgramCommand.Retrieve command);

    ProgramInfo.Basic changeBasicInfo(ProgramCommand.ChangeBasicInfo command);

    ProgramInfo.Remove remove(ProgramCommand.Remove command);

}
