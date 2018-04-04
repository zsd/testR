package com.vansec.flow.dao;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.flow.data.FlowDataProvider;
import com.vansec.flow.domain.Flow;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 流程程序测试类.
 */
public class FlowDaoTest extends AbstractTest {

    @Autowired
    private FlowDao flowDao;

    /**
     * 插入流程测试.
     */
    @Test
    public void saveTest() {
        Flow flow = FlowDataProvider.getFlow();
        flowDao.save(flow);
    }

    /**
     * 获取流程测试.
     */
    @Test
    public void getByIdTest() {
        Flow flow = flowDao.getById(DataUtils.ID_1);
        Assert.assertNotNull(flow);
    }

}
