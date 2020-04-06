package com.viettel.ems.fm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * The type Error response.
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    private Date timestamp;
    private String status;
    private String message;
    private String details;
}
