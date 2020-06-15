package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import phim.itsol.domain.Schedule;
import phim.itsol.dto.ScheduleDto;
import phim.itsol.exception.EmailExistException;
import phim.itsol.exception.UsernameExistException;
import phim.itsol.repo.ManagerRepository;
import phim.itsol.repo.RoleRepository;
import phim.itsol.repo.ScheduleRepository;
import phim.itsol.service.ScheduleService;

import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void Establish(ScheduleDto scheduleDto) throws UsernameExistException, EmailExistException {
        log.trace("Service to create schedule in web site");
    }

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Optional<Schedule> getSchedule() {
        return Optional.empty();
    }
}
