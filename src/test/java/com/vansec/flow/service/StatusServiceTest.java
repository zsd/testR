package com.vansec.flow.service;

import bussiness.comm.ObjectTypeFactory;
import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.flow.data.StatusDataProvider;
import com.vansec.flow.domain.support.Status;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 状态程序测试类.
 */
public class StatusServiceTest extends AbstractTest {

    @Autowired
    private StatusService statusService;

    /**
     * 保存1测试.
     */
    @Test
    public void save1Test() {
        Status status = StatusDataProvider.getStatus1();
        statusService.save(status);
    }

    /**
     * 保存2测试.
     */
    @Test
    public void save2Test() {
        Status status = StatusDataProvider.getStatus2();
        statusService.save(status);
    }

    /**
     * 根据ID获取状态测试.
     */
    @Test
    public void getByIdTest() {
        Status status = statusService.getById(DataUtils.ID_1);
        Assert.assertNotNull(status);
    }

    /**
     * 根据对象类型ID获取状态测试.
     */
    @Test
    public void getByObjectTypeIdTest() {
        List<Status> statusList = statusService.getByObjectTypeId(ObjectTypeFactory.ID_EXAMPLE);
        Assert.assertNotNull(statusList);
    }

    /**
     * 根据当前状态获取下一个状态.
     */
    @Test
    public void getNextTest() {
        Status status = statusService.getNext(DataUtils.ID_1);
        Assert.assertNotNull(status);
    }

    /**
     * 根据当前状态获取上一个状态.
     */
    @Test
    public void getPreTest() {
        Status status = statusService.getPre(DataUtils.ID_2);
        Assert.assertNotNull(status);
    }

    /**
     * *******************************************************
     *                    业务字典值添加
     * *******************************************************
     */
    /**
     * 添加状态字典1.
     */
}
