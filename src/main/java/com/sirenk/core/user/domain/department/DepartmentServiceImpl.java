package com.sirenk.core.user.domain.department;

import com.sirenk.core.common.exception.EntityHasChildrenException;
import com.sirenk.core.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentStorer departmentStorer;
    private final DepartmentReader departmentReader;
    private final DepartmentInfoMapper departmentInfoMapper;

    @Override
    @Transactional
    public DepartmentInfo.Basic register(DepartmentCommand.Register command) {
        var initDepartment = command.toEntity();
        var department = departmentStorer.store(initDepartment);
        var info = departmentInfoMapper.of(department);
        return info.toBuilder().parent(departmentInfoMapper.of(department.getParent())).build();
    }

    @Override
    @Transactional(readOnly = true)
    public Department find(DepartmentCommand.Retrieve command) {
        if (StringUtils.isEmpty(command.getToken())) return null;
        return departmentReader.read(command.getToken());
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentInfo.Hierarchy retrieve(DepartmentCommand.Retrieve command) {
        var department = departmentReader.readRecursively(command.getToken());
        return departmentInfoMapper.hierarchy(department);
    }

    @Override
    @Transactional
    public DepartmentInfo.ChangeBasicInfo changeBasicInfo(DepartmentCommand.ChangeBasicInfo command) {
        var deparment = departmentReader.read(command.getToken());
        deparment.changeBasicInfo(command.getName());
        return departmentInfoMapper.changeBasicInfo(deparment);
    }

    @Override
    @Transactional
    public DepartmentInfo.Move move(DepartmentCommand.Move command) {
        var department = departmentReader.read(command.getToken());
        var parentDepartment = departmentReader.read(command.getParentToken());
        department.changeParent(parentDepartment);
        department.renewPath();

        var info = departmentInfoMapper.move(department);
        return info.toBuilder().parent(departmentInfoMapper.move(department.getParent())).build();
    }

    @Override
    @Transactional
    public DepartmentInfo.Remove remove(DepartmentCommand.Remove command) {
        var department = departmentReader.read(command.getToken());
        if (department.getChildren().size() != 0) {
            throw new EntityHasChildrenException(ErrorCode.ENTITY_HAS_CHILDREN.getErrorMsg(department.getName(), department.getChildren().size()));
        }
        departmentStorer.remove(department);
        return departmentInfoMapper.remove(department);
    }

}
