package com.viettel.ems.fm;

import com.viettel.ems.fm.model.CurrentAlarm;
import com.viettel.ems.fm.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FM.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    // private String getRootUrl() {
    //     return "https://localhost:8080/api";
    // }
    private String getRootUrl() {
        return "https://localhost:" + port + "/api";
    }

    @Test
    public void testGetAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            getRootUrl() + "/user/all", HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
        log.info(response.getBody());
    }

    @Test
    public void testGetUserById() {
        User user = restTemplate.getForObject(getRootUrl() + "/user/1", User.class);
        log.info(user.getFirstName());
        Assert.assertNotNull(user);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setCreatedBy("admin");
        user.setUpdatedBy("admin");

        var response = restTemplate.postForEntity(getRootUrl() + "/user/users", user, User.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        log.info("Response: {}", response);
    }

    @Test
    public void testUpdatePost() {
        int id = 1;
        User user = restTemplate.getForObject(getRootUrl() + "/user/users/" + id, User.class);
        user.setFirstName("admin1");
        user.setLastName("admin2");

        restTemplate.put(getRootUrl() + "/user/users/" + id, user);

        User updatedUser = restTemplate.getForObject(getRootUrl() + "/user/users/" + id, User.class);
        Assert.assertNotNull(updatedUser);
    }

    @Test
    public void testDeletePost() {
        int id = 2;
        User user = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
        Assert.assertNotNull(user);

        restTemplate.delete(getRootUrl() + "/user/" + id);

        try {
            user = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testCreateAlarmCurrent() throws ParseException {
        var today = Calendar.getInstance().getTime();
        var sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
        var currentTime = sdf.format(today);
        var date = sdf.parse(currentTime);
        CurrentAlarm alarmcurrent = CurrentAlarm.builder()
            .alarmId(2000)
            .message("ALM_1111| node abc down")
            .severity(1)
            .keyGen("1111_mss1")
            .repeatCount(1)
            .createTime(date.getTime())
            .lastChange(date.getTime())
            .build();

        ResponseEntity<CurrentAlarm> postResponse = restTemplate.postForEntity(
            getRootUrl() + "/alarm/current", alarmcurrent, CurrentAlarm.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void testGetAllAlarmCurrent() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            getRootUrl() + "/alarm/current", HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
        log.info("Response: {}", response);
    }
}

