package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import phim.itsol.domain.Role;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByRoleName(String roleName);
}
