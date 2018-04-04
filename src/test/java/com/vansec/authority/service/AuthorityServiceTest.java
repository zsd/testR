package com.vansec.authority.service;

import com.vansec.AbstractTest;
import com.vansec.authority.data.AuthorityDataProvider;
import com.vansec.authority.domain.Authority;
import com.vansec.comm.DataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;

/**
 * 角色测试用例.
 * @author zhousd
 */
public class AuthorityServiceTest extends AbstractTest {

    @Autowired
    private AuthorityService authorityService;

    @Test
    public void testSave() {
        Authority authority = AuthorityDataProvider.getAuthority();
        authorityService.save(authority);
    }

    @Test
    public void testGetByRoleId() {
        List<Authority> authorityList = authorityService.getByRoleId(DataUtils.ID_1);
        Assert.notEmpty(authorityList);
    }

    @Test
    public void testGetByPostId() {
        Set<String> set = authorityService.getSetByPostId(DataUtils.ID_1);
        Assert.notEmpty(set);
        Assert.isTrue(set.contains("test"));
    }
}
