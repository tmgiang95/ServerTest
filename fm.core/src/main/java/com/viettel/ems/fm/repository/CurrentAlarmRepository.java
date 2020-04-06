package com.viettel.ems.fm.repository;

import com.viettel.ems.fm.model.CurrentAlarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAlarmRepository extends JpaRepository<CurrentAlarm, Long> { }
