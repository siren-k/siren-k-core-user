package com.sirenk.core.user.domain.department;

public interface DepartmentService {

    DepartmentInfo.Basic register(DepartmentCommand.Register command);

    Department find(DepartmentCommand.Retrieve command);

    DepartmentInfo.Hierarchy retrieve(DepartmentCommand.Retrieve command);

    DepartmentInfo.ChangeBasicInfo changeBasicInfo(DepartmentCommand.ChangeBasicInfo command);

    DepartmentInfo.Move move(DepartmentCommand.Move command);

    DepartmentInfo.Remove remove(DepartmentCommand.Remove command);

}
