package com.sirenk.core.user.domain.role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleStorer roleStorer;
    private final RoleReader roleReader;
    private final RoleInfoMapper roleInfoMapper;

    @Override
    @Transactional
    public RoleInfo.RoleBasic register(RoleCommand.Register command) {
        var initRole = command.toEntity();
        var role = roleStorer.store(initRole);
        return roleInfoMapper.basic(role);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleInfo.RoleBasic retrieve(RoleCommand.Retrieve command) {
        var role = roleReader.read(command.getToken());
        return roleInfoMapper.basic(role);
    }

    @Override
    @Transactional
    public RoleInfo.RoleBasic changeBasicInfo(RoleCommand.ChangeBasicInfo command) {
        var role = roleReader.read(command.getToken());
        role.changeBasicInfo(command.getName(), command.getDescription(), command.isEnable());
        return roleInfoMapper.basic(role);
    }

    @Override
    @Transactional
    public RoleInfo.RoleRemove remove(RoleCommand.Remove command) {
        var role = roleReader.read(command.getToken());
        roleStorer.remove(role);
        return roleInfoMapper.remove(role);
    }

    @Override
    @Transactional
    public RoleInfo.RoleBasic attachAuthority(RoleCommand.AttachAuthority command) {
        var role = roleReader.read(command.getToken());
        role.attachAuthority(command.getAuthority());
        return roleInfoMapper.basic(role);
    }

    @Override
    @Transactional
    public RoleInfo.RoleBasic detachAuthority(RoleCommand.DetachAuthority command) {
        var role = roleReader.read(command.getToken());
        role.detachAuthority(command.getAuthority());
        return roleInfoMapper.basic(role);
    }


}
