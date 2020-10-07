package com.yudachi.citylife.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class CompanyApply {
    private Integer id;
    private Integer uid;
    private Integer cid;
    private Date applyTime;
}
