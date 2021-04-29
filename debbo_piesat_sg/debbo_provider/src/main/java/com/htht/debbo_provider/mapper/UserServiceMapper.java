package com.htht.debbo_provider.mapper;

import com.htht.debbo_provider.entity.UserInfoPo;

/**
 * @program: debbo_piesat_sg
 * @description: mapper层
 * @author: Zhao Lianlian
 * @create: 2021-04-28 09:47
 */
public interface UserServiceMapper {
    /**
     * 单点登录查询接口
     * @param workNo
     * @return
     */
    UserInfoPo userInfo(String workNo);
}
