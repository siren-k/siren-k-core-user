package com.sirenk.core.user.domain.program;

public interface ProgramService {

    ProgramInfo.Register register(ProgramCommand.Register command);

    ProgramInfo.Retrieve retrieve(ProgramCommand.Retrieve command);

    ProgramInfo.ChangeBasicInfo changeBasicInfo(ProgramCommand.ChangeBasicInfo command);

    ProgramInfo.Remove remove(ProgramCommand.Remove command);

}
