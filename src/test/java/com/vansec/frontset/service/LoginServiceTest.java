package com.vansec.frontset.service;

import com.vansec.AbstractTest;
import com.vansec.comm.orm.Page;
import com.vansec.example.domain.Example;
import com.vansec.example.service.ExampleService;
import com.vansec.org.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录服务测试类.
 */
public class LoginServiceTest extends AbstractTest {

    @Autowired
    private LoginService loginService;
    
    /**
     * 登录测试.
     */
    @Test
    public void loginTest(){
        User user = new User("admin", "123");
        loginService.login(user);
    }

    /**
     * 登出测试.
     */
    @Test
    public void logoutTest(){
        loginService.logout();
    }

}
