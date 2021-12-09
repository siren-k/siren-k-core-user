package com.sirenk.core.user.domain.department;

public interface DepartmentService {

    DepartmentInfo.DepartmentBasicParent register(DepartmentCommand.Register command);

    Department find(DepartmentCommand.Retrieve command);

    DepartmentInfo.DepartmentBasicChildren retrieve(DepartmentCommand.Retrieve command);

    DepartmentInfo.DepartmentBasicParent changeBasicInfo(DepartmentCommand.ChangeBasicInfo command);

    DepartmentInfo.DepartmentBasicParent move(DepartmentCommand.Move command);

    DepartmentInfo.DepartmentRemove remove(DepartmentCommand.Remove command);

}
