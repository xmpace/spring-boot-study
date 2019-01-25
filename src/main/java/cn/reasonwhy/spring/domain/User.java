package cn.reasonwhy.spring.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private Date createTime;
    private Date modifyTime;
}
