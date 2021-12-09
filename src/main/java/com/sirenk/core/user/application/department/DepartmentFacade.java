package com.sirenk.core.user.application.department;

import com.sirenk.core.user.domain.department.DepartmentCommand;
import com.sirenk.core.user.domain.department.DepartmentInfo;
import com.sirenk.core.user.domain.department.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentFacade {

    private final DepartmentService departmentService;

    public DepartmentInfo.DepartmentBasicParent register(DepartmentCommand.Register command) {
        var department =
                departmentService.find(
                        DepartmentCommand.Retrieve.builder()
                                .token(command.getParentToken())
                                .build());
        var newCommand =
                command.toBuilder()
                        .parent(department)
                        .build();
        return departmentService.register(newCommand);
    }

    public DepartmentInfo.DepartmentBasicChildren retrieve(DepartmentCommand.Retrieve command) {
        return departmentService.retrieve(command);
    }

    public DepartmentInfo.DepartmentBasicParent changeBasicInfo(DepartmentCommand.ChangeBasicInfo command) {
        return departmentService.changeBasicInfo(command);
    }

    public DepartmentInfo.DepartmentBasicParent move(DepartmentCommand.Move command) {
        return departmentService.move(command);
    }

    public DepartmentInfo.DepartmentRemove remove(DepartmentCommand.Remove command) {
        return departmentService.remove(command);
    }

}
