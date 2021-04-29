package com.htht.debbo_provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.htht.common.util.DateUtil;
import com.htht.debbo_provider.entity.UserInfoPo;
import com.htht.debbo_provider.mapper.UserServiceMapper;
import com.htht.common.response.BaseResponse;
import com.htht.service.user.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;  //这个service注解可以省略掉    <!--5、声明暴露的服务接口-->
//    <dubbo:service interface="com.htht.service.user.UserServiceMapper" ref="userService" />

/**
 * @program: debbo_piesat
 * @description: 人员接口实现类
 * @author: Zhao Lianlian
 * @create: 2021-04-27 08:56
 */
@Service(version = "1.0.0")//设置版本号
public class UserServiceImpl1 implements UserService {
    private static final Logger log= LoggerFactory.getLogger(UserServiceImpl1.class);
    @Autowired
    private UserServiceMapper userServiceMapper;
    @Override
    public String getUserInfo(String workNo) {
        System.out.println("第一版本");
        return "第一版本    ---》"+workNo;
    }

    @Override
    public BaseResponse userInfo(String workNo, String account, String password) {
        //具体业务实现
        UserInfoPo userInfo=userServiceMapper.userInfo(workNo);
        if(ObjectUtils.isEmpty(userInfo)){
            log.info("响应结果1：{} ",userInfo);
            return BaseResponse.error("没有人员工号为： "+workNo+"员工存在！请检查人员信息！");
        }else{
            if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
                log.info("响应结果2：{} ",userInfo);
                return BaseResponse.error("员工账号或密码信息存在空数据，请填写完毕！");
            }else{
                if (!StringUtils.equalsIgnoreCase(account,userInfo.getAccount()) || !StringUtils.equalsIgnoreCase(password,userInfo.getPassword())){
                    log.info("响应结果3：{} ",userInfo);
                    return BaseResponse.error("员工账号或密码信息不正确请谨慎填写！");
                }
            }
        }
        log.info("响应结果4：{} ",userInfo);
        return BaseResponse.success(userInfo);
    }
}