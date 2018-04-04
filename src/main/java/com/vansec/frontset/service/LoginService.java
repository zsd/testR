package com.vansec.frontset.service;

import com.vansec.org.domain.User;

/**
 * 用户服务接口.
 * @author zhousd
 */
public interface LoginService {

    /**
     * 用户登录.
     * 临时实现
     */
    String login(User user);

    /**
     * 用户登出.
     */
    void logout();

}
