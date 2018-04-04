package com.vansec.flow.data;

import bussiness.comm.ObjectTypeFactory;
import com.vansec.comm.DataUtils;
import com.vansec.comm.utils.Identities;
import com.vansec.example.domain.Example;
import com.vansec.flow.domain.Task;
import com.vansec.flow.domain.support.Status;
import com.vansec.org.data.PostDataProvider;
import com.vansec.org.domain.Post;

/**
 * Task测试数据提供类.
 * @author zhousd
 */
public final class TaskDataProvider {

    /**
     * 生成状态.
     */
    public static Task getTask() {
        Post post = PostDataProvider.post1();
        Example example = new Example("1", "张三", "男");
        Status status = new Status("测试状态");
        status.setId("123");
        example.setStatus(status);
        Task task = new Task(example, post);
        task.setId(DataUtils.ID_1);
        return task;
    }

    private TaskDataProvider() {}
}
