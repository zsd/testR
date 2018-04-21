package com.vansec.authority.service;

import com.vansec.AbstractTest;
import com.vansec.authority.data.RoleDataProvider;
import com.vansec.authority.domain.Role;
import com.vansec.comm.DataUtilsTest;
import com.vansec.user.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 角色测试用例.
 * @author zhousd
 */
public class RoleServiceTest extends AbstractTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testSave() {
        Role role = RoleDataProvider.getRole();
        roleService.save(role);
    }

    @Test
    public void testGetByUserId() {
        List<Role> roles = roleService.getByUserId("75da578ca634427691fdea5f2e59f32f");
        Assert.assertNotNull(roles);
    }


    @Test
    public void testsaveUserRole() {
        User user = new User();
        user.setId("1");
        Role role = new Role();
        role.setId(DataUtilsTest.ID_1);
        user.setRole(role);
        roleService.saveUserRole(user);
    }
}
