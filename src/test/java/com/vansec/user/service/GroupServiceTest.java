package com.vansec.user.service;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.user.data.GroupDataProvider;
import com.vansec.user.data.UserDataProvider;
import com.vansec.user.domain.Group;
import com.vansec.user.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * 用户组服务测试用例.
 * @author zhousd
 */
public class GroupServiceTest extends AbstractTest {

    @Autowired
    private GroupService groupService;

    /**
     * 保存测试.
     */
    @Test
    public void saveTest(){
        Group group = GroupDataProvider.getGroup();
        groupService.save(group);
    }

    /**
     * 查询测试.
     */
    @Test
    public void getByIdTest(){
        Group group = groupService.getById(DataUtils.ID_1);
        Assert.notNull(group);
    }

    /**
     * 更新测试.
     */
    @Test
    public void updateTest(){
        Group group = groupService.getById(DataUtils.ID_1);
        groupService.update(group);
    }
    /**
     * 更新测试.
     */
    @Test
    public void deleteTest(){
        groupService.delete(DataUtils.ID_1);
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
        Group group = GroupDataProvider.getGroup();
        group.setId(null);
        groupService.save(group);
    }

}
