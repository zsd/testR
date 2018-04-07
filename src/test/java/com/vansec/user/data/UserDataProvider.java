package com.vansec.user.data;

import com.vansec.comm.DataUtils;
import com.vansec.user.domain.User;

/**
 * 用户测试数据提供类
 */
public class UserDataProvider {

    private UserDataProvider() {}

    public static User getUser() {
        User user = new User();
        user.setId(DataUtils.ID_1);
        user.setName("测试用户_001");
        user.setLoginName("test1");
        user.setPassword("123");
        user.setPhone("18681891234");
        user.setEmail("test1@sina.com");
        user.setPhoto("aaa.jpg");
        user.setWechatId("wechatid1");
        user.setWechatName("wechatname1");
        user.setWeiboId("weiboid1");
        user.setWeiboName("weiboname1");
        user.setRewardMoney(100);
        user.setRewardPoint(100);
        return user;
    }
}
