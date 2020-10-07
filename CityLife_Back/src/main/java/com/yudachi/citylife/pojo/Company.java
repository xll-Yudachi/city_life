package com.yudachi.citylife.pojo;

import lombok.Data;

import java.sql.Date;


@Data
public class Company {
    private int id;
    private String name;
    private String legalRep;
    private Float usd;
    private Date establishTime;
    private Integer empType;
    private Integer status;
    private Integer stage;
    private String scale;
    private String industry;
    private String webSite;
    private String logo;
    private String abbreviation;
    private Integer audit;
}
