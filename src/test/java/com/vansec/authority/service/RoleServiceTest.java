package com.vansec.authority.service;

import com.vansec.AbstractTest;
import com.vansec.authority.data.AuthorityDataProvider;
import com.vansec.authority.domain.Role;
import com.vansec.comm.DataUtils;
import com.vansec.org.domain.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
        Role role = AuthorityDataProvider.getRole();
        roleService.save(role);
    }

    @Test
    public void testGetByPostId() {
        List<Role> roles = roleService.getByPostId("75da578ca634427691fdea5f2e59f32f");
        Assert.assertNotNull(roles);
    }


    @Test
    public void testsaveOrgRole() {
        Post post = new Post();
        post.setId("1");
        post.setType(3);
        List<Role> roleList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            Role role = new Role();
            role.setId("aa" + i);
            roleList.add(role);
        }
        post.setRoleList(roleList);
        roleService.saveOrgRole(post);
    }
}
