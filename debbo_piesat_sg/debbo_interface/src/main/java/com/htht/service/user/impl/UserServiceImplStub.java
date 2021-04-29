package com.htht.service.user.impl;

import com.htht.common.response.BaseResponse;
import com.htht.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: debbo_piesat_sg
 * @description: 存根，这里的作用是设置如果很多接口服务都从这个接口走的话，则出现很多consumer扥逻辑都要写，这样的话每个consumer都需要写判断，十分麻烦
 * 代理类UserServiceImplStub，具体实现调用接口的部分
 * @author: Zhao Lianlian
 * @create: 2021-04-27 16:40
 */
public class UserServiceImplStub implements UserService {
    private static final Logger log= LoggerFactory.getLogger(UserServiceImplStub.class);
    private final UserService userService;

    //服务容器会给我们注入具体的人实现
    public UserServiceImplStub(UserService userService){
        this.userService=userService;
    }

    @Override
    public String getUserInfo(String workNo) {
        //编写具体的处理逻辑
        if(StringUtils.isEmpty(workNo)){
            return "400  无参数设置，不允许访问服务提供者";
        }
        System.out.println(userService);
        return userService.getUserInfo(workNo);
    }

    @Override
    public BaseResponse userInfo(String workNo, String account, String password) {
        if(StringUtils.isEmpty(workNo)){
            log.info("响应结果：{} ","人员工号是员工唯一标识不能为空,请检查！");
            return BaseResponse.result(1001, "人员工号是员工唯一标识不能为空,请检查！");
        }
        BaseResponse response=userService.userInfo(workNo,account,password);
        log.info("响应结果0：{} ",response);
        return response;
    }
}