package com.yudachi.citylife.dto;

import lombok.Data;

@Data
public class MediaListQuery {
    private Integer page;
    private Integer limit;
    private String startTime;
    private String endTime;
    private String mediaType;
    private String used;
}
