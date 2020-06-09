package phim.itsol.security;

import phim.itsol.domain.Manager;
import phim.itsol.repo.ManagerRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Component("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    private final ManagerRepository managerRepository;

    public UserDetailServiceImpl(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return managerRepository.findOneWithAuthoritiesByManagerUsername(username)
                .map(manager -> createSpringSecurityUser(username, manager))
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found in the database"));

    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String login, Manager manager) {
        List<GrantedAuthority> grantedAuthorities = manager.getRoleList()
                .stream().map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(manager.getManagerUsername(),
                manager.getManagerPassword(), grantedAuthorities);
    }


}
