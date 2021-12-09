package com.sirenk.core.user.domain.program;

public interface ProgramService {

    ProgramInfo.ProgramBasic register(ProgramCommand.Register command);

    Program find(ProgramCommand.Retrieve command);

    ProgramInfo.ProgramBasic retrieve(ProgramCommand.Retrieve command);

    ProgramInfo.ProgramBasic changeBasicInfo(ProgramCommand.ChangeBasicInfo command);

    ProgramInfo.ProgramBasic changeScreen(ProgramCommand.ChangeScreen command);

    ProgramInfo.ProgramBasic changeApi(ProgramCommand.ChangeApi newCommand);

    ProgramInfo.ProgramRemove remove(ProgramCommand.Remove command);

}
