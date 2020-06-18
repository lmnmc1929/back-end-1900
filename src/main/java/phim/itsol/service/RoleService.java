package phim.itsol.service;

import phim.itsol.domain.Role;

import java.util.Set;

public interface RoleService {
    Role getRoleByRoleName(String roleName);
}
