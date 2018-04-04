package com.vansec.flow.service;

import bussiness.comm.ObjectTypeFactory;
import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.flow.data.ActivityDataProvider;
import com.vansec.flow.data.StatusDataProvider;
import com.vansec.flow.domain.Activity;
import com.vansec.flow.domain.support.Status;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 状态程序测试类.
 */
public class FlowServiceTest extends AbstractTest {

    @Autowired
    private FlowService flowService;

    @Autowired
    private TaskService taskService;

    /**
     * 起始流程执行测试.
     */
    @Test
    public void exetuteStartTest() {
        Activity activity = ActivityDataProvider.getStartActivity();
        flowService.execute(activity);
    }

    /**
     * 审批流程执行测试.
     */
    @Test
    public void exetuteApprovalTest() {
        Activity activity = ActivityDataProvider.getApprovalActivity();
        activity.setTask(taskService.getById("da6dce089d824e488bec85f651091be6"));
        flowService.execute(activity);
    }

    /**
     * 受理流程执行测试.
     */
    @Test
    public void exetuteAcceptTest() {
        Activity activity = ActivityDataProvider.getAcceptActivity();
        activity.setTask(taskService.getById("377a56e2313245ffa839f74fd9cef111"));
        flowService.execute(activity);
    }

    /**
     * 办结流程执行测试.
     */
    @Test
    public void exetuteEndTest() {
        Activity activity = ActivityDataProvider.getEndActivity();
        activity.setTask(taskService.getById("3fc2e945eed44140b576f2e550918c05"));
        flowService.execute(activity);
    }
}
