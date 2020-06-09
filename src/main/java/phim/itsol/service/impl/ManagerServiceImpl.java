package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Manager;
import phim.itsol.repo.ManagerRepository;
import phim.itsol.security.SecurityUtils;
import phim.itsol.service.ManagerService;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ManagerServiceImpl implements ManagerService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ManagerRepository managerRepository;

//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public Optional<Manager> getManagerWithRoleList() {
        return SecurityUtils.getCurrentUserLogin().flatMap(managerRepository::findOneWithAuthoritiesByManagerUsername);
    }
}
