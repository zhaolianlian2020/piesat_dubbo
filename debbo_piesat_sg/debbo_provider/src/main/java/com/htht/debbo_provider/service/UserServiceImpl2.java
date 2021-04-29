//package com.htht.debbo_provider.service;
//
//import com.alibaba.dubbo.config.annotation.Service;
//import UserService;
////import org.springframework.stereotype.Service;  //这个service注解可以省略掉    <!--5、声明暴露的服务接口-->
////    <dubbo:service interface="com.htht.service.user.UserServiceMapper" ref="userService" />
//
///**
// * @program: debbo_piesat
// * @description: 人员接口实现类
// * @author: Zhao Lianlian
// * @create: 2021-04-27 08:56
// */
//@Service(version = "2.0.0")
//public class UserServiceImpl2 implements UserService {
//    @Override
//    public String getUserInfo(String workNo) {
//        System.out.println("第二版本");
//        return "第二版本    ---》"+workNo;
//    }
//}