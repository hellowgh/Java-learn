package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    private Integer id;
    private String username; // 用户名
    private String password;
    private String name; // 姓名
    private Short gender; // 1 男； 2 女
    private String image;
    private Short job; // 1 班主任；2 讲师； 3 学工主管； 4 校验主任； 5 咨询师
    private LocalDate entrydate;
    private Integer deptId;
    private LocalDate createTime;
    private LocalDate updateTime;

}
