package com.htht.debbo_provider.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: debbo_piesat_sg
 * @description: 用户信息
 * @author: Zhao Lianlian
 * @create: 2021-04-28 01:07
 */
@ToString
@Data
public class UserInfoPo implements Serializable {
    private Integer id;
    //姓名
    private String name;
    //账号
    private String account;
    //登录密码
    private String password;
    //工号
    private String workNo;
    //邮件
    private String email;
    //住址
    private String address;
    //公司
    private String company;
    //部门
    private String organization;
    //性别
    private String gender;
    //备注
    private String remark;
    //工资
    private BigDecimal salary;
    //入职日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    //表产生时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //表修改时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    //生日
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}