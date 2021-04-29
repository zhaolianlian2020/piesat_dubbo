package com.htht.debbo_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.htht.common.response.BaseResponse;
import com.htht.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: debbo_piesat
 * @description: 单点登录人员接口消费方
 * @author: Zhao Lianlian
 * @create: 2021-04-27 09:25
 */
@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    private static final String prefix="sso";
//细粒度控制，timeout这里指的是连接5秒，防止雪崩
//    @Reference(loadbalance = "roundrobin" ,timeout = 5000)   //轮训策略,
//    @Reference(loadbalance = "leastactive" ,timeout = 5000)  //最小活跃数，属于细粒度控制，全局配置需要在application.properties文件中设置
//    @Reference(loadbalance = "consistenthash" ,timeout = 5000)  //一致性hash策略，不必担心个别微服务提供者出现崩盘，2的23次方个节点，有分层的性质，顺时针选择提供者
//    @Reference(cluster = "failfast") //集群服务容错方式，这里是快速失败，默认是失败快速切换
//    @Reference(stub = "UserServiceImplStub") //存根地址，若是多个consumer调用则会同样判断，不是我们想要的，这里用到了代理模式
    @Reference
    private UserService userService;

    @RequestMapping("hello")
    public String getUserInfo(@RequestParam("workNo") String workNo){
        //调用远程服务
        String msg = "";
        try{
            msg=userService.getUserInfo(workNo);
        }catch (Exception e){
            new Throwable(e);
        }
        return msg;
    }

    /**
     * 测试的hello world
     * @param param
     * @return
     */
    @RequestMapping(value = prefix+"/server",method = RequestMethod.GET)
    public BaseResponse test(@RequestParam String param){
        return BaseResponse.success(param);
    }

    /**
     * 违单点登录
     * @param workNo 工号
     * @param account 账户
     * @param password 密码
     * @return
     */
    @RequestMapping(value = prefix+"/userInfo",method = RequestMethod.GET)
    public BaseResponse userInfo(@RequestParam String workNo,@RequestParam String account,@RequestParam String password){
        BaseResponse response=userService.userInfo(workNo,account,password);
        log.info("响应结果：{} ",response.getData());
        return BaseResponse.success(response);
    }


}