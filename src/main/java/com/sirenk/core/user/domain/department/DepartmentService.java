package com.sirenk.core.user.domain.department;

public interface DepartmentService {

    DepartmentInfo.BasicParent register(DepartmentCommand.Register command);

    Department find(DepartmentCommand.Retrieve command);

    DepartmentInfo.BasicChildren retrieve(DepartmentCommand.Retrieve command);

    DepartmentInfo.BasicParent changeBasicInfo(DepartmentCommand.ChangeBasicInfo command);

    DepartmentInfo.BasicParent move(DepartmentCommand.Move command);

    DepartmentInfo.Remove remove(DepartmentCommand.Remove command);

}
