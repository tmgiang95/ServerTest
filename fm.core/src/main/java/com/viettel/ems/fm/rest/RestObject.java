package com.viettel.ems.fm.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestObject {
    private long id;
    private String content;
    private List<Integer> list;
}
