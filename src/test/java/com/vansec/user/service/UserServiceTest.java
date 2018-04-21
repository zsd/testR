package com.vansec.user.service;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtilsTest;
import com.vansec.user.data.UserDataProvider;
import com.vansec.user.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * 岗位服务测试用例.
 * @author zhousd
 */
public class UserServiceTest extends AbstractTest {

    @Autowired
    private UserService userService;

    /**
     * 保存测试.
     */
    @Test
    public void saveTest(){
        User user = UserDataProvider.getUser();
        userService.save(user);
    }

    /**
     * 查询测试.
     */
    @Test
    public void getByIdTest(){
        User user = userService.getById(DataUtilsTest.ID_1);
        Assert.notNull(user);
    }

    /**
     * 更新测试.
     */
    @Test
    public void updateTest(){
        User user = userService.getById(DataUtilsTest.ID_1);
        user.setPhone("1232132");
        userService.update(user);
    }
    /**
     * 更新测试.
     */
    @Test
    public void deleteTest(){
        userService.delete(DataUtilsTest.ID_1);
    }


    /**
     * **********************************************
     *                业务需要
     * **********************************************
     */

    /**
     * 添加管理员，admin、123.
     */
    @Test
    public void saveAdminTest(){
        User user = UserDataProvider.getUser();
        user.setId(null);
        user.setLoginName("admin");
        user.setName("管理员");
        userService.save(user);
    }

}
