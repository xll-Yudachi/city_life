package com.yudachi.citylife.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class Resume {
    private Integer id;
    private String name;
    private String phone;
    private Integer sex;
    private Date birth;
    private String position;
    private String guard;
    private String direction;
    private String salary;
    private String avatar;
    private String workExp;
    private String studyExp;
    private String evaluation;
    private Integer uid;
    private Date attachTime;
    private String wxId;
    private String email;
}
