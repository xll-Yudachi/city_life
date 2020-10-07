package com.yudachi.citylife.dto;

import lombok.Data;

@Data
public class CompanyListQuery {
    private Integer page;
    private Integer limit;
    private String comName;
    private String auditSubmitTime;
    private String auditType;
    private String sort;
}
