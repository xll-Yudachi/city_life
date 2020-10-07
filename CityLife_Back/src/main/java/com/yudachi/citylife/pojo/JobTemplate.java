package com.yudachi.citylife.pojo;

import lombok.Data;

@Data
public class JobTemplate {
    private Integer id;
    private Integer uid;
    private String name;
    private String salary;
    private String province;
    private String exp;
    private String degree;
    private String skillTag;
    private Integer used;
    private String type;
}
