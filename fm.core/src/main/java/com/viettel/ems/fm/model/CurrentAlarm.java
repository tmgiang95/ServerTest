package com.viettel.ems.fm.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "alarm_current")
@EntityListeners(AuditingEntityListener.class)
public class CurrentAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "alarm_id", nullable = false)
    private int alarmId;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "severity", nullable = false)
    private int severity;

    @Column(name = "rptcnt", nullable = false)
    private int repeatCount;

    @Column(name = "key_gen", nullable = false)
    private String keyGen;

    @Column(name = "create_time", nullable = false)
    private long createTime;

    @Column(name = "last_change", nullable = false)
    private long lastChange;
}
