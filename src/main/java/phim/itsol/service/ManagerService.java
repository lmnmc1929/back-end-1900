package phim.itsol.service;

import phim.itsol.domain.Manager;

import java.util.Optional;

public interface ManagerService {
    /**
     *
     * @return Optional<Manager>
     */
    Optional<Manager> getManagerWithRoleList();
}
