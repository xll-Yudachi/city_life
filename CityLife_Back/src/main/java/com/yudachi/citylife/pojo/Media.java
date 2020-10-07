package com.yudachi.citylife.pojo;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class Media {
    private Integer id;
    private Integer mediaType;
    private String url;
    private Integer used;
    private Timestamp uploadTime;
}
