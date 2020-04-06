package com.viettel.ems.fm.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/** Created to make life harder */
@Data
@AllArgsConstructor
public class RestWrapper {
    private AtomicLong id;
    private String metadata;
    private RestObject data;
    private Map<String, String> map;
}
