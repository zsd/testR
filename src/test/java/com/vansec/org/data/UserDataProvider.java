package com.vansec.org.data;

import com.vansec.comm.DataUtils;
import com.vansec.org.domain.User;

/**
 * 用户测试数据提供类
 */
public class UserDataProvider {

    private UserDataProvider() {}

    public static User getUser1() {
        User user = new User();
        user.setId(DataUtils.ID_1);
        user.setName("测试用户_001");
        user.setLoginName("testuser");
        user.setPassword("123");
        user.setPhone("18681891234");
        return user;
    }

    public static User getUser2() {
        User user = new User();
        user.setId("UTU_002");
        user.setName("测试用户_002");
        return user;
    }

    public static User getUser3() {
        User user = new User();
        user.setId("UTU_003");
        user.setName("测试用户_003");
        return user;
    }
}
