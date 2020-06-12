package phim.itsol.repo;

import phim.itsol.domain.Manager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import phim.itsol.domain.Manager;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, String> {

    String USERS_BY_LOGIN_CACHE = "getByManagerUsername";

    @EntityGraph(attributePaths = "roleList")
    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<Manager> findOneWithRoleListByManagerUsername(String managerUsername);
    //Optional<Manager> findManagerByManagerUsername(String managerUsername);




}
