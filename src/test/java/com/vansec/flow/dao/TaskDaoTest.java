package com.vansec.flow.dao;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.flow.data.TaskDataProvider;
import com.vansec.flow.domain.Task;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 状态程序测试类.
 */
public class TaskDaoTest extends AbstractTest {

    @Autowired
    private TaskDao taskDao;

    /**
     * 插入任务测试.
     */
    @Test
    public void insertTest() {
        Task task = TaskDataProvider.getTask();
        taskDao.insert(task);
    }

    /**
     * 获取任务测试.
     */
    @Test
    public void getByIdTest() {
        Task task = taskDao.getById(DataUtils.ID_1);
        Assert.assertNotNull(task);
    }

    /**
     * 任务已读测试.
     */
    @Test
    public void readTest() {
        taskDao.read(Task.ISREADED_YES, DataUtils.ID_1);
    }

    /**
     * 任务已读测试.
     */
    @Test
    public void getByObjectIdTest() {
        List<Task> taskList = taskDao.getByObjectId(DataUtils.ID_1);
        Assert.assertNotNull(taskList);
    }

    /**
     * 根据活动获取任务.
     */
    @Test
    public void getByActivityIdTest() {
        String activityId = "ddedee9c97694032813a9b8ed68bdf32";
        Task task = taskDao.getByActivityId(activityId);
        Assert.assertNotNull(task);
    }

}
