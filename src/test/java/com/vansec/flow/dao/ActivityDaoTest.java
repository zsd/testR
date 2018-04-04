package com.vansec.flow.dao;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.flow.data.ActivityDataProvider;
import com.vansec.flow.domain.Activity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 流程活动程序测试类.
 */
public class ActivityDaoTest extends AbstractTest {

    @Autowired
    private ActivityDao activityDao;

    /**
     * 插入任务测试.
     */
    @Test
    public void saveTest() {
        Activity activity = ActivityDataProvider.getApprovalActivity();
        activityDao.save(activity);
    }

    /**
     * 获取任务测试.
     */
    @Test
    public void getByIdTest() {
        Activity activity = activityDao.getById(DataUtils.ID_1);
        Assert.assertNotNull(activity);
    }

    /**
     * 根据流程ID获取活动列表.
     */
    @Test
    public void getByFlowIdTest() {
        List<Activity> activityList = activityDao.getByFlowId(DataUtils.ID_1);
        Assert.assertNotNull(activityList);
    }

}
