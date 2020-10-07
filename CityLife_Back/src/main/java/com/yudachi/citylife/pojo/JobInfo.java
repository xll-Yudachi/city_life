package com.yudachi.citylife.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class JobInfo {
    private Integer id;
    private String name;
    private String salary;
    private Integer companyId;
    private Integer describeId;
    private String address;
    private Timestamp updateTime;
    private String province;
    private String exp;
    private String degree;
    private String skillTag;
    private String type;
}
