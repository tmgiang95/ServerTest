package com.viettel.ems.fm.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viettel.ems.fm.model.CurrentAlarm;
import com.viettel.ems.fm.repository.CurrentAlarmRepository;

import lombok.Data;

@Data
@RestController
@RequestMapping("/api/alarm")
public class CurrentAlarmController {

    private CurrentAlarmRepository alarmRepository;

    @PostMapping("/current")
    public CurrentAlarm createAlarm(@Valid @RequestBody CurrentAlarm alarm) {
        CurrentAlarm alm = alarmRepository.findById(alarm.getId()).orElse(alarm);
        return alarmRepository.save(alm);
    }

}
