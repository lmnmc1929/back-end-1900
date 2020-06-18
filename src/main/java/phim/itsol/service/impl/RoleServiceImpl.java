package phim.itsol.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Role;
import phim.itsol.repo.RoleRepository;
import phim.itsol.service.RoleService;


@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }
}
