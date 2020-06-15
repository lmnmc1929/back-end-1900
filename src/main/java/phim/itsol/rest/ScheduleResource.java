package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.constants.AppConstants;
import phim.itsol.dto.ResponseDto;
import phim.itsol.dto.ScheduleDto;
import phim.itsol.service.ScheduleService;


@RestController
@RequestMapping("/api")
public class ScheduleResource {
    private Logger log = LoggerFactory.getLogger(ScheduleResource.class);

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/createNewSchedule")
    public ResponseEntity<ResponseDto> register(@RequestBody ScheduleDto scheduleDto){
        log.trace("REST request to register user website: {}", scheduleDto);
        ResponseDto responseDto = new ResponseDto();
        try{
            scheduleService.Establish(scheduleDto);
            responseDto.setResponseCode(AppConstants.RESPONSE_OK);
        } catch (Exception exception){
            responseDto.setResponseCode(AppConstants.RESPONSE_ERRORS);
            responseDto.setMessage(exception.getMessage());
        }
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/get-profile")
    public ResponseEntity<ScheduleDto> getProfile(){
        ScheduleDto scheduleDto = scheduleService.getSchedule()
                .map(ScheduleDto::new)
                .orElseThrow(() -> new ScheduleResourceException("Schedule could not be found"));
        return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
    }


    private static class ScheduleResourceException extends RuntimeException {
        private ScheduleResourceException(String message) {
            super(message);
        }
    }
}
