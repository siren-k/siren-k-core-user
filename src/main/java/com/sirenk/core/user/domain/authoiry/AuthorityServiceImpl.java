package com.sirenk.core.user.domain.authoiry;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityStorer authorityStorer;
    private final AuthorityReader authorityReader;
    private final AuthorityInfoMapper authorityInfoMapper;

    @Override
    @Transactional
    public AuthorityInfo.AuthorityBasic register(AuthorityCommand.Register command) {
        var initAuthority = command.toEntity();
        var authority = authorityStorer.store(initAuthority);
        return authorityInfoMapper.basic(authority);
    }

    @Override
    @Transactional(readOnly = true)
    public Authority find(AuthorityCommand.Retrieve command) {
        return authorityReader.read(command.getToken());
    }

    @Override
    @Transactional(readOnly = true)
    public AuthorityInfo.AuthorityBasic retrieve(AuthorityCommand.Retrieve command) {
        var authority = authorityReader.read(command.getToken());
        return authorityInfoMapper.basic(authority);
    }

    @Override
    @Transactional
    public AuthorityInfo.AuthorityBasic changeBasicInfo(AuthorityCommand.ChangeBasicInfo command) {
        var authority = authorityReader.read(command.getToken());
        authority.changeBasicInfo(command.getName(), command.getDescription(), command.isEnable());
        return authorityInfoMapper.basic(authority);
    }

    @Override
    @Transactional
    public AuthorityInfo.AuthorityRemove remove(AuthorityCommand.Remove command) {
        var authority = authorityReader.read(command.getToken());
        authorityStorer.remove(authority);
        return authorityInfoMapper.remove(authority);
    }

    @Override
    @Transactional
    public AuthorityInfo.AuthorityBasic attachProgram(AuthorityCommand.AttachProgram command) {
        var authority = authorityReader.read(command.getToken());
        authority.attachProgram(command.getProgram());
        return authorityInfoMapper.basic(authority);
    }

    @Override
    public AuthorityInfo.AuthorityBasic detachProgram(AuthorityCommand.DetachProgram command) {
        var authority = authorityReader.read(command.getToken());
        authority.detachProgram(command.getProgram());
        return authorityInfoMapper.basic(authority);
    }

}
