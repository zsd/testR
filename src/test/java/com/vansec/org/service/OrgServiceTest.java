package com.vansec.org.service;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.comm.orm.Page;
import com.vansec.org.data.OrgDataProvider;
import com.vansec.org.domain.Org;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 岗位服务测试用例.
 * @author zhousd
 */
public class OrgServiceTest extends AbstractTest {

    @Autowired
    private OrgService orgService;

    /**
     * 保存测试.
     */
    @Test
    public void saveTest() {
        Org org = OrgDataProvider.getOrg1();
        org.setParent(null);
        orgService.save(org);
    }

    /**
     * 查询测试.
     */
    @Test
    public void getByIdTest() {
        Org org = orgService.getById(DataUtils.ID_1);
        Assert.notNull(org);
    }

    /**
     * 更新测试.
     */
    @Test
    public void updateTest() {
        Org org = orgService.getById(DataUtils.ID_1);
        org.setName("修改单位名称");
        orgService.update(org);
    }

    /**
     * 更新测试.
     */
    @Test
    public void deleteTest() {
        orgService.delete(DataUtils.ID_1);
        Org org = orgService.getById(DataUtils.ID_1);
        Assert.isNull(org);
    }

    /**
     * 更新测试.
     */
    @Test
    public void searchTest() {
        Page<Org> orgs = new Page<>();
        Map<String, Object> param = new HashMap<>();
        orgService.search(orgs, param);
        Assert.notNull(orgs);
    }

}
