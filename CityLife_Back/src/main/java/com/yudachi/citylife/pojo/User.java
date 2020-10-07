package com.yudachi.citylife.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String phone;
    private String pwd;
    private Integer rank;
    private String email;
}
