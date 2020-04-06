package com.viettel.ems.fm.controller;

import com.viettel.ems.fm.exception.ResourceNotFoundException;
import com.viettel.ems.fm.model.Alarm;
import com.viettel.ems.fm.repository.AlarmRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

//import org.springframework.http.ResponseEntity;
//import java.util.Date;

@Data
@RestController
@RequestMapping("/api/alarm")
public class AlarmController {

    private AlarmRepository alarmRepository;

    @Autowired
    public AlarmController(AlarmRepository alarmRepository) {
        this.alarmRepository = alarmRepository;
    }

    @GetMapping("/all")
    public List<Alarm> getAllAlarm() {
        return alarmRepository.findAll();
    }

    /** Create Alarm Current. */
    @PostMapping("/current")
    public Alarm createAlarm(@Valid @RequestBody Alarm alarm) {
        Alarm alm = alarmRepository.findById(alarm.getId()).orElse(alarm).copyProps(alarm);
        return alarmRepository.save(alm);
    }

    @GetMapping("/current/{id}")
    public Alarm getAlarm(@PathVariable(value = "id") Long alarmId) throws ResourceNotFoundException {
        return alarmRepository
            .findById(alarmId)
            .orElseThrow(() -> new ResourceNotFoundException("Cannot find alarm with id " + alarmId + "."));
    }

    @DeleteMapping("/current/{id}")
    public Map<String, String> deleteAlarmCurrent(
        @PathVariable(value = "id") Long alarmId
    ) throws ResourceNotFoundException {
        Alarm alarm = alarmRepository
            .findById(alarmId)
            .orElseThrow(
                () -> new ResourceNotFoundException("The alarm with id " + alarmId + " is not exist to delete"));
        alarmRepository.delete(alarm);
        return Map.of("message", "The alarm with the id " + alarmId + " has been deleted successfully.");
    }
}
