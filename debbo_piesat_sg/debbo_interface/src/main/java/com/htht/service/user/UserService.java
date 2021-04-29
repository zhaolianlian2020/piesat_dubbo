package com.htht.service.user;

import com.htht.common.response.BaseResponse;

/**
 * @program: debbo_piesat
 * @description: 人员接口
 * @author: Zhao Lianlian
 * @create: 2021-04-27 08:52
 */
public interface UserService {
    public String getUserInfo(String name);
    public BaseResponse userInfo(String workNo,String account, String password);
}
