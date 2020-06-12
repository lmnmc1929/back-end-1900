package phim.itsol.service;

import phim.itsol.domain.Manager;
import phim.itsol.dto.ManagerDto;
import phim.itsol.exception.EmailExistException;
import phim.itsol.exception.UsernameExistException;

import java.util.Optional;

public interface ManagerService {
    /**
     *
     * @return Optional<Manager>
     */
    void register(ManagerDto managerDto) throws UsernameExistException, EmailExistException;
    Optional<Manager> getManagerWithRoleList();
}
