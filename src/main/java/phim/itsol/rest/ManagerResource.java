package phim.itsol.rest;


import phim.itsol.constants.AppConstants;
import phim.itsol.dto.ManagerDto;

import phim.itsol.dto.ResponseDto;
import phim.itsol.service.ManagerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerResource {

    private Logger log = LoggerFactory.getLogger(ManagerResource.class);

    @Autowired
    private ManagerService managerService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody ManagerDto managerDto){
        log.trace("REST request to register user website: {}", managerDto);
        ResponseDto responseDto = new ResponseDto();
        try{
            managerService.register(managerDto);
            responseDto.setResponseCode(AppConstants.RESPONSE_OK);
        } catch (Exception exception){
            responseDto.setResponseCode(AppConstants.RESPONSE_ERRORS);
            responseDto.setMessage(exception.getMessage());
        }
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/get-profile")
    public ResponseEntity<ManagerDto> getProfile(){
        ManagerDto managerDto = managerService.getManagerWithRoleList()
                .map(ManagerDto::new)
                .orElseThrow(() -> new AccountResourceException("User could not be found"));
        return new ResponseEntity<>(managerDto, HttpStatus.OK);
    }


    private static class AccountResourceException extends RuntimeException {
        private AccountResourceException(String message) {
            super(message);
        }
    }

}
