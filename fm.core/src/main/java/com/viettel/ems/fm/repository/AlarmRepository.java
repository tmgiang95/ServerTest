package com.viettel.ems.fm.repository;

import com.viettel.ems.fm.model.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Alarm repository.
 *
 * @author Trunglq7 Le Quoc Trung
 */
@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> { }
