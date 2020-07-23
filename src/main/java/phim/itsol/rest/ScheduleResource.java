package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.constants.AppConstants;
import phim.itsol.domain.Schedule;
import phim.itsol.dto.ResponseDto;
import phim.itsol.dto.ScheduleDto;
import phim.itsol.service.ScheduleService;


@RestController
@RequestMapping("/api/schedule")
public class ScheduleResource {
    private Logger log = LoggerFactory.getLogger(ScheduleResource.class);

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/createNewSchedule")
    public ResponseEntity<ResponseDto> schedule(@RequestBody ScheduleDto scheduleDto){
        log.trace("REST request to schedule website: {}", scheduleDto);
        ResponseDto responseDto = new ResponseDto();
        try{
            scheduleService.create(scheduleDto);
            responseDto.setResponseCode(AppConstants.RESPONSE_OK);
        } catch (Exception exception){
            responseDto.setResponseCode(AppConstants.RESPONSE_ERRORS);
            responseDto.setMessage(exception.getMessage());
        }
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/find-one_schedule/{scheduleId}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long scheduleId){
        log.trace("REST to request get room: {}", scheduleId);
        Schedule schedule = scheduleService.getSchedule(scheduleId);
        if(schedule==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        }
    }


    private static class ScheduleResourceException extends RuntimeException {
        private ScheduleResourceException(String message) {
            super(message);
        }
    }
}
