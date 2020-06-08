package phim.itsol.repo;

import phim.itsol.domain.Manager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import phim.itsol.domain.Manager;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, String> {

    String USERS_BY_LOGIN_CACHE = "getByUsername";

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<Manager> findOneWithAuthoritiesByUsername(String username);

    @EntityGraph(attributePaths = "authorities")
    Optional<Manager> findOneWithAuthoritiesByEmail(String username);


}
