package com.viettel.ems.fm.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Slf4j
@Data
@Entity
@Table(name = "alarm")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private Integer type;

    @Column(name = "cal_type")
    private Integer calType;

    @Column(name = "enable")
    private Integer enable;

    @Column(name = "minatt")
    private int minatt;

    @Column(name = "msg_alarm")
    private String msgAlarm;

    @Column(name = "msg_resolve")
    private String msgResolve;

    @Column(name = "default_severity")
    private Integer defaultSeverity;

    @Column(name = "event_rate")
    private Integer eventRate;

    @Column(name = "timeout")
    private Integer timeout;

    @Column(name = "threshold")
    private Integer threshold;

    public Alarm copyProps(Alarm alarm) {
        if (this == alarm) return this;
        log.info("Copying");

        setName(alarm.name);
        setDescription(alarm.description);
        setType(alarm.type);
        setCalType(alarm.calType);
        setEnable(alarm.enable);
        setMinatt(alarm.minatt);
        setMsgAlarm(alarm.msgAlarm);
        setMsgResolve(alarm.msgResolve);
        setDefaultSeverity(alarm.defaultSeverity);
        setEventRate(alarm.eventRate);
        setTimeout(alarm.timeout);
        setThreshold(alarm.threshold);

        return this;
    }
}

